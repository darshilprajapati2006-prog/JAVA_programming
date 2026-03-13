package Exception_Handling;

public class ThrowsDemo {
    void div(int a,int b) throws ArithmeticException
    {
        if(b==0){
            throw new ArithmeticException();
        }
        else{
            int c=a/b;
            System.out.println(c);
        }
    }

    static void main(String[] args) {
        ThrowsDemo t = new ThrowsDemo();
        try{
            t.div(20,0);
        }
        catch (Exception e) {
            System.out.println("the value of b is 0");
        }
    }
}
