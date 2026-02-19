package OOPs;
interface raj{
    void add();
}
interface gill extends raj{
    void sub();
}
class Ankit implements gill{
    @Override
    public void add(){
        int a=10,b=20,c;
        c=a+b;
        System.out.println("addition : "+c);
    }
    @Override
    public void sub(){
        int a=10,b=20,c;
        c=a-b;
        System.out.println("subtraction : "+c);
    }
}
public class ExtendInterface {
    static void main(String[] args) {
        gill r = new Ankit();
        r.add();
        r.sub();
    }
}
