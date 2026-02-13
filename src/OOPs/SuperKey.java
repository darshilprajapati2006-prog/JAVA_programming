package OOPs;
class a1{
    int a=10;
}
class a2 extends a1{
    int a=20;
    void display(){
        System.out.println(a);
        System.out.println(super.a);
    }

}
public class SuperKey {
    static void main(String[] args) {
        a2 r = new a2();
        r.display();
    }
}
