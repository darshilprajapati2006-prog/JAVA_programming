package OOPs;

interface client1{
    void webdesign();
    void webdevelope();
}
abstract class rajtech implements client1{
    @Override
    public void webdesign()
    {
        System.out.println("Green,top menu,three dot button");
    }
}
public class InterfaceMethods extends rajtech {
    @Override
    public void webdevelope(){
        System.out.println("html,css,java script");
    }
}

class check{
    static void main(String []args) {
        InterfaceMethods r = new  InterfaceMethods();
        r.webdesign();
        r.webdevelope();
    }
}