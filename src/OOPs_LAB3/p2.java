package OOPs_LAB3;


abstract class Figure {

    protected double pi = 3.1420;
    protected double a;
    protected double v;

    public abstract void calcArea();
    public abstract void calcVol();
    public abstract void DispArea();
    public abstract void DispVol();
}


class Cone extends Figure {

    double r, h, s;

    Cone(double r, double h, double s) {
        this.r = r;
        this.h = h;
        this.s = s;
    }

    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    public void calcVol() {
        v = (pi * r * r * h) / 3;
    }

    public void DispArea() {
        System.out.println("Cone Area = " + a);
    }

    public void DispVol() {
        System.out.println("Cone Volume = " + v);
    }
}


class Sphere extends Figure {

    double r;

    Sphere(double r) {
        this.r = r;
    }

    public void calcArea() {
        a = 4 * pi * r * r;
    }

    public void calcVol() {
        v = (4 * pi * r * r * r) / 3;
    }

    public void DispArea() {
        System.out.println("Sphere Area = " + a);
    }

    public void DispVol() {
        System.out.println("Sphere Volume = " + v);
    }
}

class Cylinder extends Figure {

    double r, h;

    Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public void calcArea() {
        a = (2 * pi * r * h) + (2 * pi * r * r);
    }

    public void calcVol() {
        v = pi * r * r * h;
    }

    public void DispArea() {
        System.out.println("Cylinder Area = " + a);
    }

    public void DispVol() {
        System.out.println("Cylinder Volume = " + v);
    }
}


public class p2 {

    public static void main(String[] args) {

        Cone cone = new Cone(7, 10, 12);
        cone.calcArea();
        cone.calcVol();
        cone.DispArea();
        cone.DispVol();

        System.out.println();

        Sphere sphere = new Sphere(5);
        sphere.calcArea();
        sphere.calcVol();
        sphere.DispArea();
        sphere.DispVol();

        System.out.println();

        Cylinder cylinder = new Cylinder(4, 9);
        cylinder.calcArea();
        cylinder.calcVol();
        cylinder.DispArea();
        cylinder.DispVol();
    }
}
