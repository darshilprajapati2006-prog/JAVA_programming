package Exception_Handling;

public class NestedFinally {
    static void main(String[] args) {
        try{
            String str = "darshil";
            System.out.println(str.toUpperCase());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {

            try{
                System.out.println(10/0);
            }
            catch(ArithmeticException a){
                System.out.println(a);
            }
            finally {
                System.out.println("learn coding");
            }
        }
        System.out.println("main method ended");
    }
}
