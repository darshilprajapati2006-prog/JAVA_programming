package basicsOFjava;

public class StringMethods {
    public static void main(String[] args) {
        String name = "darshil";
        System.out.println(name);
        int length = name.length();
        System.out.println("length : "+length);

        String lname = name.toLowerCase();
        System.out.println("lowercase : "+lname);

        String uname = name.toUpperCase();
        System.out.println("uppercase : "+uname);


        String str = "        Darshil       ";
        System.out.println(str);

        System.out.println(str.trim()) ;

        System.out.println(name.replace('a','i'));
        System.out.println(name.substring(2));

    }
}
