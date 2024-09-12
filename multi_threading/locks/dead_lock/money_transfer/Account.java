package multi_threading.locks.dead_lock.money_transfer;

public class Account {

    private Long accountNo;

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    private String name;
    private long amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(Long accountNo,String name, long amount) {
        this.accountNo = accountNo;
        this.name = name;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


    public void deduct(long amount){
        if(this.amount < amount){
            throw new RuntimeException();
        }
        this.amount = this.amount - amount;
    }
    public void add(long amount){
        this.amount = this.amount + amount;
    }
}
