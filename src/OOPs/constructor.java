package OOPs;

public class constructor {
    public static void main(String[] args) {
        Account a1 = new Account(101, "darshil", 45000.0);
        Account a2 = new Account(102, "mishra", 35000.0);
        a1.showAccount();
        a2.showAccount();
    }
}
    class Account{
        private int accId;
        private String name;
        private double balance;

    public Account(int id,String n,double bal){
        accId = id;
        name = n;
        balance = bal;
        System.out.println("constructor called");
    }
    public void showAccount(){
        System.out.println("id = "+accId);
        System.out.println("name = "+name);
        System.out.println("balance = "+balance);
    }
}
