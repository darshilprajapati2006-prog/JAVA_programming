package OOPs;
class a{
    void input(){
        System.out.println("enter your name : ");
    }
}
class b1 extends a{
    void show(){
        System.out.println("my name is darshil");
    }
}
class b2 extends a{
    void display(){
        System.out.println("my name is ankit");
    }
}
public class Hierarchical_inheritance {
    static void main(String[] args) {
        b1 r1 = new b1();
        b2 r2 = new b2();
        r1.input();
        r1.show();
        r2.input();
        r2.display();
    }
}
