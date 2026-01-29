package OOPs;

class Box{
    double length;
    double breadth;
    double volume;

    void insert(double a,double b,double c){
    length = a;
    breadth = b;
    volume = c;
    }

    double calculate_volume(){
        return length*breadth*volume;
    }
}

public class p3 {
    public static void main(String[] args) {
        Box x = new Box();
        x.insert(13,45,33);

        double volume = x.calculate_volume();
        System.out.println("volume = "+volume);
    }
}
