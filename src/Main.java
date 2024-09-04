import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean new_account, repeat = true;
        Scanner obj = new Scanner(System.in);
        System.out.print("Hello! Do you already have an account (0) or do you want to make a new one (1)?");


        if(obj.nextInt() == 0){
            new_account = false;
        }else{
            new_account = true;
        }

        obj.nextLine();

        Accounts accounts = new Accounts();
        Banking user = new Banking();

        while(repeat) {
            if (new_account) {
                String name;
                String age;
                String phone_number;
                String id;

                System.out.print("Enter your name : \n");
                name = obj.nextLine();
                user.setName(name);

                System.out.print("Enter your age : \n");
                age = obj.nextLine();
                user.setAge(age);

                System.out.print("Enter your phone number : ");
                phone_number = obj.nextLine();
                user.setPhone(phone_number);

                id = user.writeAccount(name, age, phone_number);
                accounts.addAccount(id, user);
                repeat = false;
            } else {
                System.out.print("Enter your account id: ");
                String id = obj.nextLine();
                boolean exists = accounts.checkIfExists(id);
                if (!exists) {
                    System.out.print("Your account does not exist. Try again!");
                }else{
                    repeat = false;
                }
            }
        }
        System.out.println("How much money do you have?");
        double money = obj.nextDouble();
        user.setBalance(money);

        repeat = true;
        while(repeat) {
        System.out.println("What would you like to do?");
        System.out.println("Deposit money (0)");
        System.out.println("Transfer money (1)");
        System.out.println("Withdraw money (2)");
        System.out.println("See your information (3)");

            switch (obj.nextInt()) {
                case 0:
                    System.out.println("How much money would you like to deposit?");
                    double deposit_money = obj.nextDouble();
                    user.deposit(deposit_money);
                    break;
                case 1:
                    obj.nextLine();
                    System.out.println("What ID would you like to transfer to and how much money?");
                    String transfer_id = obj.nextLine();
                    double transfer_money = obj.nextDouble();
                    user.transfer(accounts.mapA.get(transfer_id), transfer_money);
                    break;
                case 2:
                    System.out.println("How much money would you like to withdraw?");
                    double withdraw_money = obj.nextDouble();
                    user.withdraw(withdraw_money);
                    break;
                case 3:
                    System.out.println("Account ID: " + user.getID());
                    System.out.println("Account user Name: " + user.getName());
                    System.out.println("Account user Phone number: " + user.getPhone());
                    System.out.println("Account user Age: " + user.getAge());
                    System.out.println("Account user Balance: " + user.getBalance());
                    break;
            }

            System.out.println("Do you want to do anything else? (yes - 1, no -0)");
            if(obj.nextInt() == 0) {
                repeat = false;
            }
        }

    }
}