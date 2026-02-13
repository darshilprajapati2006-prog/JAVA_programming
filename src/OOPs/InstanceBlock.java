package OOPs;
class Ib{
    int a;
    int b;
    Ib(){
        a=10;
        b=30;
        System.out.println(a+" "+b);
    }
    {
        a=77;
        b=56;
        System.out.println(a+" "+b);
    }

}

public class InstanceBlock {
    static void main(String[] args) {
        Ib r = new Ib();
    }
}
