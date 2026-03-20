package OOPs_LAB6;
/*
START
CREATE class Point3D
    DEFINE x,y,z
            DEFAULT constructor → set 0,0,0
PARAM constructor → set x,y,z
METHOD input()
        INPUT x,y,z
METHOD display()
PRINT (x,y,z)
METHOD distance(p2)
CALCULATE sqrt((x2-x1)^2+(y2-y1)^2+(z2-z1)^2)
RETURN distance
MAIN
CREATE p1 using input
CREATE p2 using parameter constructor
DISPLAY both
CALCULATE distance
PRINT distance
END
 */

import java.util.Scanner;
class Point3D {
    int x,y,z;
    Point3D() {
        x=0;y=0;z=0;
    }
    Point3D(int a,int b,int c) {
        x=a;y=b;z=c;
    }
    void input() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter x y z: ");
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
    }
    void display() {
        System.out.println("("+x+","+y+","+z+")");
    }
    double distance(Point3D p) {
        return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y)+(p.z-z)*(p.z-z));
    }
}
public class p6 {
    public static void main(String[] args) {
        Point3D p1=new Point3D();
        p1.input();
        Point3D p2=new Point3D(3,4,5);
        p1.display();
        p2.display();
        double d=p1.distance(p2);
        System.out.println("Distance: "+d);
    }
}
