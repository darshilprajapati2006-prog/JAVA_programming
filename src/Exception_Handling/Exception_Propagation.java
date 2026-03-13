package Exception_Handling;

public class Exception_Propagation {
    public static void main(String[] args) {
        try{
            m1();
        }
        catch(ArithmeticException e){
            System.out.println("exception handaled by main method");
        }
    }
    public static void m1(){
        m2();
    }
    public static void m2(){
        System.out.println(10/0);
    }
}
