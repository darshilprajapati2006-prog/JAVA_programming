package OOPs_LAB5;
import java.util.Scanner;

class Product {
    int productId;
    String name;
    int categoryId;
    double unitPrice;
}

class ElectricalProduct extends Product {
    String voltageRange;
    int wattage;

    void update(int newWattage, double newPrice) {
        wattage = newWattage;
        unitPrice = newPrice;
    }

    void display() {
        System.out.println(productId);
        System.out.println(name);
        System.out.println(categoryId);
        System.out.println(unitPrice);
        System.out.println(voltageRange);
        System.out.println(wattage);
    }
}

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ElectricalProduct e = new ElectricalProduct();

        System.out.print("Enter Product ID: ");
        e.productId = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Product Name: ");
        e.name = sc.nextLine();

        System.out.print("Enter Category ID: ");
        e.categoryId = sc.nextInt();

        System.out.print("Enter Unit Price: ");
        e.unitPrice = sc.nextDouble();

        sc.nextLine();
        System.out.print("Enter Voltage Range: ");
        e.voltageRange = sc.nextLine();

        System.out.print("Enter Wattage: ");
        e.wattage = sc.nextInt();

        System.out.print("Enter New Wattage: ");
        int newWattage = sc.nextInt();

        System.out.print("Enter New Price: ");
        double newPrice = sc.nextDouble();

        e.update(newWattage, newPrice);
        e.display();
    }
}