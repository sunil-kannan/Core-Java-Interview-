package multi_threading.locks.dead_lock.money_transfer;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Payment {
    public void transfer(Account from, Account to, long amount) {
        try {
            synchronized (from) {
                Thread.sleep(100);
                synchronized (to) {
                    Thread.sleep(100);
                    from.deduct(amount);
                    to.add(amount);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Account getLarger(Account acc1, Account acc2) {
        return acc1.getAccountNo() < acc2.getAccountNo() ? acc2 : acc1;
    }

    private Account getSmaller(Account acc1, Account acc2) {
        return acc2.getAccountNo() < acc1.getAccountNo() ? acc2 : acc1;
    }

    public void transferWithSafety(Account from, Account to, long amount) {
        Account acc1 = getLarger(from, to);
        Account acc2 = getSmaller(from, to);
        try {
            synchronized (acc1) {
                Thread.sleep(100);
                synchronized (acc2) {
                    Thread.sleep(100);
                    from.deduct(amount);
                    to.add(amount);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void detectDeadLock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        boolean deadLock = threadIds != null && threadIds.length > 0;
        System.out.println("------------ Dead locks found: " + deadLock + " ----------------");
    }

    public static void main(String[] args) throws InterruptedException {
        Payment payment = new Payment();
        Account acc1 = new Account(39747494L, "Sunil", 4000);
        Account acc2 = new Account(39747495L, "Godson", 3400);
        Account acc3 = new Account(39747496L, "Navin", 4000);
        Account acc4 = new Account(39747497L, "Kabilan", 3400);
        Account acc5 = new Account(39747496L, "Navin", 4000);
        Account acc6 = new Account(39747497L, "Kabilan", 3400);
        System.out.println("Acc4 hash: "+acc4.hashCode());
        System.out.println("Acc6 hash: "+acc6.hashCode());


        /*
            2 users are concurrently making payments, which can lead to deadlock.
            Although we are using the synchronized keyword to lock the account objects,
            deadlock can occur when threads try to acquire locks on the accounts in different orders.
        */
        Runnable transfer1 = () -> payment.transfer(acc1, acc2, 500);
        Runnable transfer2 = () -> payment.transfer(acc2, acc1, 3400);
        new Thread(transfer1).start();
        new Thread(transfer2).start();
        Thread.sleep(1000);
        payment.detectDeadLock();
        System.out.println(acc1.getAmount());
        System.out.println(acc2.getAmount());

        /*
            We are performing the transfer safely by ensuring that locks are acquired in a consistent order
            based on the account number, which prevents deadlock.
            TryLock can also be used, but one payment get fails and one only get succeed, so it is better to avoid.
        */
        Runnable transfer3 = () -> payment.transferWithSafety(acc3, acc4, 500);
        Runnable transfer4 = () -> payment.transferWithSafety(acc6, acc5, 3400);
        new Thread(transfer3).start();
        new Thread(transfer4).start();
        Thread.sleep(2000);
        System.out.println(acc3.getAmount());
        System.out.println(acc4.getAmount());
        System.out.println(acc5.getAmount());
        System.out.println(acc6.getAmount());
    }
}
