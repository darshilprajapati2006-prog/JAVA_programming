package OOPs;
class E{
    private int value;  //data hiding

    public void setValue(int x) //data abstraction
    {
        value=x;
    }
    public int getValue(){
        return value;
    }

}
public class Encaptulation {
    static void main(String[] args) {
        E r = new E();
        r.setValue(100);
        System.out.println(r.getValue());
    }
}
