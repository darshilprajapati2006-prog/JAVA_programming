package basicsOFjava;

class A{
    int x,y;
    A(int x,int y){
        this.x=x;
        this.y=y;
    }
    A(int a,String b){
        System.out.println(a+" "+b);
    }
    void show(){
        System.out.println(x+" "+y);
    }
}

public class ParameterrizedConst {
    public static void main(String[] args) {
        A ref=new A(10,20);
        ref.show();
        A ref2=new A(10,"darshil");
    }
}
