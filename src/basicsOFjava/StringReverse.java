package basicsOFjava;

public class StringReverse {
    public static void main(String[] args) {
        String r1="darshil";
        String r2="";
        int n = r1.length();
        for(int i=n-1;i>=0;i--){
            r2=r2+r1.charAt(i);
        }
        System.out.println(r2);
    }
}
