package Exception_Handling;

public class throwDemo {
    void div(int a,int b){
        if(b==0){
            throw new ArithmeticException();
        }
        else{
            int c=a/b;
            System.out.println(c);
        }
    }

    static void main(String[] args) {
        throwDemo t = new throwDemo();
        t.div(20,0);
    }
}
