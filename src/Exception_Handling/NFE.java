package Exception_Handling;

public class NFE {
    public static void main(String[] args) {
        String str = "darshil";

        try {
            int a = Integer.parseInt(str);
            System.out.println(a);
            System.out.println("string number format exception");
        }
        catch (NumberFormatException e) {
            System.out.println("string" + str + "can't be converted to Integer");
        }
    }
}
