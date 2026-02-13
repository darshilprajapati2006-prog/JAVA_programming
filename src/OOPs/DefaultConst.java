package OOPs;
class A{
    int a;
    String name;

    A(){
    a=7;
    name="ankit";
    }

    void show(){
        System.out.println(a);
        System.out.println(name);
    }
}


public class DefaultConst {
    public static void main(String[] args) {
        A ref=new A();
        ref.show();
    }

}
