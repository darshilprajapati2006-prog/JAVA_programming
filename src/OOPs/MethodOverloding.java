package OOPs;
class A1 {
    void add() {
        int a = 7, b = 4, c;
        c = a + b;
        System.out.println(c);
    }

    void add(int x, int y) {
        int c;
        c = x + y;
        System.out.println(c);
    }

    void add(int x, double y) {
        double c;
        c = x + y;
        System.out.println(c);
    }
}
public class MethodOverloding {
    static void main(String[] args) {
        A1 r =new A1();
        r.add();
        r.add(100,200);
        r.add(13,37.00);
    }
}
