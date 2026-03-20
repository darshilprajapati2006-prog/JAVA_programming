package OOPs_LAB6;
/*
START
CREATE abstract class Car
    DEFINE variable
    DEFINE concrete method display()
    DECLARE abstract methods avg() and mode()
CREATE class Maruti extends Car
    IMPLEMENT avg() and mode()
CREATE class Santro extends Car
    IMPLEMENT avg() and mode()
MAIN
    CREATE reference of Car
    ASSIGN Maruti object
    CALL methods
    ASSIGN Santro object
    CALL methods
END
 */

abstract class Car {
    int speed = 100;
    void display() {
        System.out.println("Speed: " + speed);
    }
    abstract void avg();
    abstract void mode();
}

class Maruti extends Car {
    void avg() {
        System.out.println("Maruti Average: 20 kmpl");
    }
    void mode() {
        System.out.println("Maruti Mode: Manual");
    }
}

class Santro extends Car {
    void avg() {
        System.out.println("Santro Average: 18 kmpl");
    }
    void mode() {
        System.out.println("Santro Mode: Automatic");
    }
}

public class p4 {
    public static void main(String[] args) {
        Car c;
        c = new Maruti();
        c.display();
        c.avg();
        c.mode();
        c = new Santro();
        c.display();
        c.avg();
        c.mode();
    }
}
