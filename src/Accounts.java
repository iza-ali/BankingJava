import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts {
    Map<String, Banking> mapA = new HashMap<String, Banking>();

    public Accounts(){

        try {
            BufferedReader input = new BufferedReader(new FileReader("src\\accounts.txt"));
            String line;
            if ("src\\accounts".isEmpty()) {
                System.out.println("No previous accounts!");
            }else{
                while ((line = input.readLine()) != null) {
                    Banking usr = new Banking();
                    String[] arr = line.split("/");
                    usr.getAccountFromFile(arr[0]);
                    mapA.put(arr[0], usr);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addAccount(String id, Banking b){
        mapA.put(id, b);
    }

    public void editAccountBalance(Banking b, double balance){
        b.setBalance(balance);
    }


    public boolean checkIfExists(String id_account){
//        File accounts = new File("src\\accounts.txt");
//        if(accounts.length() < 1){
//            return false;
//        }
//
//        try {
//            String line;
//            BufferedReader input = new BufferedReader(new FileReader("src\\accounts.txt"));
//            while ((line = input.readLine()) != null) {
//                String[] arr = line.split("/");
//                if(arr[0].equals(id_account)){
//                    return true;
//                }
//            }
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
        return mapA.containsKey(id_account);
    }

}
