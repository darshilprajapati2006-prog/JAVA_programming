package OOPs_LAB5;

class Fruit {
    String name;
    String type;
    double price;

    Fruit(String n, String t, double p) {
        name = n;
        type = t;
        price = p;
    }

    void displayFruit() {
        System.out.println(name);
        System.out.println(type);
        System.out.println(price);
    }
}

public class p4 {
    public static void main(String[] args) {
        Fruit f1 = new Fruit("Apple", "Single", 100);
        Fruit f2 = new Fruit("Banana", "Bunch", 60);

        f1.displayFruit();
        f2.displayFruit();
    }
}