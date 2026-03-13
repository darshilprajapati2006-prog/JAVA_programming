package Exception_Handling;

public class NestedTry {
    static void main(String[] args) {
        try{
            try{
                int arr[]={10,20,30};
                System.out.println(arr[0]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
            System.out.println(10/0);
        }
        catch (ArithmeticException a) {
            System.out.println(a);
        }
        System.out.println("darshil prajapati");
    }
}
