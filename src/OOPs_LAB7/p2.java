package OOPs_LAB7;

class Vehicle {
    String brand;
    int wheels;

    Vehicle(String brand, int wheels) {
        this.brand = brand;
        this.wheels = wheels;
    }

    void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Number of wheels: " + wheels);
    }

    void maxSpeed() {
        System.out.println("Maximum speed of vehicle is not defined.");
    }
}

class Car extends Vehicle {
    String fuelType;
    int speed;

    Car(String brand, int wheels, String fuelType, int speed) {
        super(brand, wheels);
        this.fuelType = fuelType;
        this.speed = speed;
    }

    void maxSpeed() {
        System.out.println("Maximum speed of car is: " + speed + " km/h");
    }
}

class Bicycle extends Vehicle {
    String type;
    int speed;

    Bicycle(String brand, int wheels, String type, int speed) {
        super(brand, wheels);
        this.type = type;
        this.speed = speed;
    }

    void maxSpeed() {
        System.out.println("Maximum speed of bicycle is: " + speed + " km/h");
    }
}

class Scooter extends Vehicle {
    String engineType;
    int speed;

    Scooter(String brand, int wheels, String engineType, int speed) {
        super(brand, wheels);
        this.engineType = engineType;
        this.speed = speed;
    }

    void maxSpeed() {
        System.out.println("Maximum speed of scooter is: " + speed + " km/h");
    }
}

public class p2 {
    public static void main(String[] args) {
        Car car = new Car("Honda", 4, "Petrol", 180);
        Bicycle bicycle = new Bicycle("Hero", 2, "Geared", 40);
        Scooter scooter = new Scooter("Activa", 2, "Petrol", 90);

        System.out.println("Car Details");
        car.showDetails();
        System.out.println("Fuel Type: " + car.fuelType);
        car.maxSpeed();

        System.out.println();

        System.out.println("Bicycle Details");
        bicycle.showDetails();
        System.out.println("Type: " + bicycle.type);
        bicycle.maxSpeed();

        System.out.println();

        System.out.println("Scooter Details");
        scooter.showDetails();
        System.out.println("Engine Type: " + scooter.engineType);
        scooter.maxSpeed();
    }
}
