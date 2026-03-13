package Exception_Handling;

public class NestedCatch {
    static void main(String[] args) {
    try{
        System.out.println(10/0);
    }
    catch(Exception e){
        try{
            String str = null;
            System.out.println(str.toUpperCase());
        }
        catch(NullPointerException n){
            System.out.println("null value can't converted");
        }
    }
        System.out.println("main method ended");
    }
}
