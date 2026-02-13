package basicsOFjava;

class PrivateConst{
    int a;
    double b;
    String c;
    private PrivateConst(){
        a=10;
        b=20.35;
        c="darshil";
        System.out.println(a+" "+b+" "+c);
    }
    public static void main(String[] args) {

        PrivateConst ref=new PrivateConst();

    }
}
