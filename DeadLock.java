
class Account{

}

class Transfer{
    Account a;
    Account b;
//    public Transfer(Account a, Account b){
//        this.a = a;
//        this.b = b;
//    }
    public boolean transfer(Account fromAccount, Account toAccount, int amount){
        try{
            synchronized (fromAccount){
                fromAccount.wait();
                // deduct amount
                Thread.sleep(200);
                System.out.println("account deducted for the account :" + fromAccount.hashCode());
                synchronized (toAccount){
                    toAccount.wait();
                    // add amount
                }

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}

public class DeadLock extends Thread{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account();
        Transfer transfer = new Transfer();

        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                transfer.transfer(a, b, 100);
            }
        };
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                transfer.transfer(b, a, 100);
            }
        };
        thread1.run();
        thread2.run();


    }
}
