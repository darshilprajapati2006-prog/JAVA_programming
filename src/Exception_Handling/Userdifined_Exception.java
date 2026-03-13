package Exception_Handling;

class InvalidAgeException extends Exception{
    InvalidAgeException(String msg ){
        System.out.println(msg );
    }
}
public class Userdifined_Exception {
    public static void main(String[] args){
        try{
            vote(20);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void vote(int age)throws InvalidAgeException
    {

        if(age<18){
            throw new InvalidAgeException("not eligible for voting");
        }
        else{
            System.out.println("eligible for voting");
        }
    }

}

