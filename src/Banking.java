import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;


public class Banking {
    private String name;
    private String age;
    private String phone;
    private double balance;
    private String id_account;

    public Banking(){
        System.out.println("This is the banking constructor!");
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getAge(){
        return this.age;
    }

    public String getID(){
        return this.id_account;
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



    public void getAccountFromFile(String id_account){
        File accounts = new File("src\\accounts.txt");

        try {
            String line;
            BufferedReader input = new BufferedReader(new FileReader("src\\accounts.txt"));
            while ((line = input.readLine()) != null) {
                String[] arr = line.split("/");
                if(arr[0].equals(id_account)){
                    this.name = arr[1];
                    this.age = arr[2];
                    this.phone = arr[3];
                    this.balance = 1000.0;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String writeAccount(String name, String age, String phone){
        FileOutputStream fos;
        try {
            BufferedReader input = new BufferedReader(new FileReader("src\\accounts.txt"));
            String last = "", line;
            Integer new_account_number = 1;

            while ((line = input.readLine()) != null) {
                last = line;
            }

            if(last.compareTo("1") != 0){
                String[] arr = last.split("/");
                new_account_number = Integer.sum(Integer.parseInt(arr[0]), 1);
            }

            fos = new FileOutputStream("src\\accounts.txt", true);

            fos.write(String.valueOf(new_account_number).getBytes());
            fos.write("/".getBytes());
            fos.write(name.getBytes());
            fos.write("/".getBytes());
            fos.write(age.getBytes());
            fos.write("/".getBytes());
            fos.write(phone.getBytes());
            fos.write("\n".getBytes());

            fos.close();

            System.out.println("Your account has been successfully made.");
            System.out.println("Your account number is: " + String.valueOf(new_account_number));
            return Integer.toString(new_account_number);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
