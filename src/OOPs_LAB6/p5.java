package OOPs_LAB6;
/*START
CREATE class Bank
METHOD deposit(amount, balance)
RETURN balance + amount
METHOD withdraw(amount, balance)
IF balance >= amount
RETURN balance - amount
        ELSE
RETURN 0
MAIN
INPUT balance
INPUT deposit amount
CALL deposit()
PRINT new balance
INPUT withdraw amount
CALL withdraw()
PRINT new balance
        END

 */
import java.util.Scanner;
class Bank {
    double deposit(double amount, double balance) {
        return balance + amount;
    }
    double withdraw(double amount, double balance) {
        if (balance >= amount)
            return balance - amount;
        else
            return 0;
    }
}
public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter deposit amount: ");
        double dep = sc.nextDouble();
        balance = b.deposit(dep, balance);
        System.out.println("Balance after deposit: " + balance);
        System.out.print("Enter withdraw amount: ");
        double wd = sc.nextDouble();
        balance = b.withdraw(wd, balance);
        System.out.println("Balance after withdraw: " + balance);
    }
}