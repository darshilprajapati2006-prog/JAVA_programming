package OOPs_LAB3;

class X {

    int i, j;

    X(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public final int sum() {
        return i + j;
    }
}

class Y extends X {

    Y(int i, int j) {
        super(i, j);
    }

    public int product() {
        return i * j;
    }
}

class Z extends Y {

    Z(int i, int j) {
        super(i, j);
    }

    public int difference() {
        return i - j;
    }
}

public class p3 {

    public static void main(String[] args) {

        Z obj = new Z(10, 5);

        System.out.println("Sum = " + obj.sum());
        System.out.println("Difference = " + obj.difference());
        System.out.println("Product = " + obj.product());
    }
}
