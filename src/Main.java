

public class Main {
    public static void main(String[] args) {

        Banking one = new Banking(9000);
        Banking two = new Banking(1000);

        one.printBalance();
        two.printBalance();

        one.transfer(two, 2000);

        one.printBalance();
        two.printBalance();

    }
}