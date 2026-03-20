package OOPs;

class Cardemo {
    int noOfwheels;
    String color;
    float maxspeed;
    float currentfual;
    int noOfseats;

    Cardemo(){
       noOfwheels=4;
       color="black";
       maxspeed=180;
       currentfual=2;
       noOfseats=7;
    }
    public void drive(){
        if(currentfual==0){
            System.out.println("car is not driving");
        }
        else if (currentfual<5) {
            System.out.println("car is in reserved mode, please refuel it.");
            currentfual--;
        }
        else {
            System.out.println("car is driving");
            currentfual--;
        }
    }
    public void addfuel(float fuel){
        currentfual+=fuel;
    }
    public float getcurrentfuelLevel(){
        return currentfual;
    }
}
public class car {
    public static void main(String []args) {
        Cardemo ref = new Cardemo();

        System.out.println(ref.color);

        ref.addfuel(6);
        ref.drive();
        System.out.println(ref.getcurrentfuelLevel());

        ref.drive();
        System.out.println(ref.getcurrentfuelLevel());

        ref.drive();
        System.out.println(ref.getcurrentfuelLevel());

        ref.addfuel(6);
        System.out.println(ref.getcurrentfuelLevel());
        ref.drive();
        System.out.println(ref.getcurrentfuelLevel());
    }
}


