package OOPs_LAB6;
/* ->ALGO :)
START
CREATE Parent class
    DEFINE variable x
    CREATE constructor to initialize x
    CREATE display method
CREATE Child class extends Parent
    DEFINE variable x
    CREATE constructor
        CALL super(x)
        ASSIGN this.x
    CREATE display method
        PRINT parent x using super.x
        PRINT child x using this.x
MAIN
    CREATE Child object
    CALL display()
END
 */
class Parent {
    int x;

    Parent(int x) {
        this.x = x;
    }

    void display() {
        System.out.println("Parent x: " + x);
    }
}

class Child extends Parent {
    int x;

    Child(int a, int b) {
        super(a);
        this.x = b;
    }

    void display() {
        System.out.println("Parent x using super: " + super.x);
        System.out.println("Child x using this: " + this.x);
    }
}

public class p1 {
    public static void main(String[] args) {
        Child c = new Child(10, 20);
        c.display();
    }
}
