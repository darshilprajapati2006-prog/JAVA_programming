package OOPs;
interface A_1{
    void show();
}
interface A_2{
    void disp();
}
public class MultipleInterface implements A_1,A_2 {
    @Override
    public void show() {
        System.out.println("Show method");
    }

    @Override
    public void disp() {
        System.out.println("Display method");
    }

    public static void main(String[] args) {
        MultipleInterface obj = new MultipleInterface();
        obj.show();
        obj.disp();
    }
}

