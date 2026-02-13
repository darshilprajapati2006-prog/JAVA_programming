package OOPs;
class shape{
    void draw(){
        System.out.println("can't say shape type");
    }
}
class square extends shape{
    @Override
    void draw(){
        super.draw();
        System.out.println("square shape");
    }
}

public class MethodOverriding {
    static void main(String[] args) {
        shape r =new square();
        r.draw();
    }
}
