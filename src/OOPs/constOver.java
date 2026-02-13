package OOPs;
import java.util.Scanner;
    class b{
    int a;
    double b;
    String c;

    b() {
        this.a = 10;
        this.b = 7.7;
        this.c = "darshil";

    }

    b(int x){
        this.a=x;
    }
    b(double y,String z){
        this.b=y;
        this.c=z;
    }
}

public class constOver {
    public static void main(String[] args) {
        b r = new b();
        b r1 = new b(10);
        b r2 = new b(7.7, "darshil");
        System.out.println(r.a + " " + r.b + " " + r.c);
        System.out.println(r1.a);
        System.out.println(r2.b + " " + r2.c);
    }
}

