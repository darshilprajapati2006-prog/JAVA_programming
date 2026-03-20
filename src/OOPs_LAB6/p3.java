package OOPs_LAB6;
/*
START
CREATE class WashingMachine
METHOD switchOn()
    PRINT Machine ON
METHOD acceptClothes(n)
    RETURN n
METHOD acceptDetergent()
    PRINT Detergent added
METHOD switchOff()
    PRINT Machine OFF
MAIN
    CREATE object
    CALL switchOn()
    INPUT number of clothes
    CALL acceptClothes(n)
    PRINT returned value
    CALL acceptDetergent()
    CALL switchOff()
END
 */

import java.util.Scanner;
class WashingMachine {
    void switchOn() {
        System.out.println("Machine ON");
    }
    int acceptClothes(int n) {
        return n;
    }
    void acceptDetergent() {
        System.out.println("Detergent added");
    }
    void switchOff() {
        System.out.println("Machine OFF");
    }
}
public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WashingMachine wm = new WashingMachine();
        wm.switchOn();
        System.out.print("Enter number of clothes: ");
        int n = sc.nextInt();
        int clothes = wm.acceptClothes(n);
        System.out.println("Clothes accepted: " + clothes);
        wm.acceptDetergent();
        wm.switchOff();
    }
}