package Exception_Handling;

public class AerithmeticException {
    static void main(String[] args) {
        System.out.println("main method started");
        int a=10,b=0,c;
        try{
            c=a/b;
            System.out.println(c);
        }
        catch (Exception e){
            System.out.println(e);// e ki jagah pe kuch bhi sentence likh sakte haii
        }
        System.out.println("main method ended");
    }
}
