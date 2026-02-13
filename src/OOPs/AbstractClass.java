package OOPs;
abstract class Animal{
    public abstract void sound();
}
class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("Dog is barking");
    }
}
class Lion extends Animal{
    @Override
    public void sound() {
        System.out.println("Lion is roar");
    }
}

public class AbstractClass {
    static void main(String[] args) {
        Dog r1 = new Dog();
        Lion r2 = new Lion();
        r1.sound();
        r2.sound();
    }
}
