
public class Banking {
    private double balance;

    public Banking(){
        System.out.println("This is the banking constructor!");
    }

    public Banking(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        this.balance -= amount;
    }

    public void printBalance(){
        System.out.println(this.balance);
    }

    public void transfer(Banking a, double amount){
        this.balance -= amount;
        a.deposit(amount);
    }
}
