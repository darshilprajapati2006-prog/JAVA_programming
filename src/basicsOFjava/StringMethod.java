package basicsOFjava;

import java.util.Locale;

public class StringMethod {
    public static void main(String[] args) {
        String a = "ankit";
        String b = "RAHUL";

        System.out.println(a.toUpperCase());
        System.out.println(b.toLowerCase());

        System.out.println(b.charAt(2));
        System.out.println(a.indexOf('k'));

        System.out.println(a.equals(b));
        System.out.println(b.replace('H','E'));

        System.out.println(b.concat(a));
        System.out.println(b.length());

        String c="   ankush   ";
        String d="learn";

        System.out.println(c.trim());
        System.out.println(d.isEmpty());



    }
}
