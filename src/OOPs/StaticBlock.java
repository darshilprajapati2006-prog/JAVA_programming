package OOPs;
class Sb{
    int a;
    int b;
    Sb(){
        System.out.println("hello world");
    }
    static{
        int a=15;
        int b=20;
        System.out.println(a+" "+b);
    }
    {
        a=7;
        b=10;
        System.out.println(a+" "+b);
    }

}

public class StaticBlock {
    static void main(String[] args) {
        Sb r = new Sb();
    }
}
