package OOPs_LAB3.p4_java;

// abstract parent class
abstract class Figure {

    protected double r;
    protected double a;
    protected double v;
    protected double pi = 3.1428;

    public abstract void calcArea();
    public abstract void calcVolume();
    public abstract void dispArea();
    public abstract void dispVolume();
}

// Cone class
class Cone extends Figure {

    double h, s;

    Cone(double r, double h, double s) {
        this.r = r;
        this.h = h;
        this.s = s;
    }

    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    public void calcVolume() {
        v = (pi * r * r * h) / 3;
    }

    public void dispArea() {
        System.out.println("Cone Area = " + a);
    }

    public void dispVolume() {
        System.out.println("Cone Volume = " + v);
    }
}

// Sphere class
class Sphere extends Figure {

    Sphere(double r) {
        this.r = r;
    }

    public void calcArea() {
        a = 4 * pi * r * r;
    }

    public void calcVolume() {
        v = (4 * pi * r * r * r) / 3;
    }

    public void dispArea() {
        System.out.println("Sphere Area = " + a);
    }

    public void dispVolume() {
        System.out.println("Sphere Volume = " + v);
    }
}

// Cylinder class
class Cylinder extends Figure {

    double h;

    Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public void calcArea() {
        a = (2 * pi * r * r) + (2 * pi * r * h);
    }

    public void calcVolume() {
        v = pi * r * r * h;
    }

    public void dispArea() {
        System.out.println("Cylinder Area = " + a);
    }

    public void dispVolume() {
        System.out.println("Cylinder Volume = " + v);
    }
}

// Main class
public class p4 {

    public static void main(String[] args) {

        Cone cone = new Cone(7, 10, 12);
        cone.calcArea();
        cone.calcVolume();
        cone.dispArea();
        cone.dispVolume();

        System.out.println();

        Sphere sphere = new Sphere(5);
        sphere.calcArea();
        sphere.calcVolume();
        sphere.dispArea();
        sphere.dispVolume();

        System.out.println();

        Cylinder cylinder = new Cylinder(4, 9);
        cylinder.calcArea();
        cylinder.calcVolume();
        cylinder.dispArea();
        cylinder.dispVolume();
    }
}