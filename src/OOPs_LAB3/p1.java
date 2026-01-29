package OOPs_LAB3;


class figure {

    double r;
    double a;
    double v;


    public void dispArea() {
        System.out.println("Area = " + a);
    }

    public void dispVolume() {
        System.out.println("Volume = " + v);
    }
}

class cone extends figure {

    double h;
    double s;

    public void calcArea() {
        a = (Math.PI * r * s) + (Math.PI * r * r);
    }

    public void calcVolume() {
        v = (Math.PI * r * r * h) / 3;
    }
}

public class p1 {

    public static void main(String[] args) {

        cone c = new cone();

        c.r = 7;
        c.h = 10;
        c.s = 12;

        c.calcArea();
        c.calcVolume();

        c.dispArea();
        c.dispVolume();
    }
}