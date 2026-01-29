package OOPs;

class Student{
    int stdId;
    String name;
    double cgpa;

    public void printdetailes(){
        System.out.println("my id : "+stdId);
        System.out.println("my name : "+name);
        System.out.println("my cgpa :"+cgpa);

    }
}

public class p1 {
    public static void main(String[] args) {
        Student a1 = new Student();
        Student a2 = new Student();

        a1.stdId=7;
        a1.name="darshil";
        a1.cgpa=7.7;

        a2.stdId=8;
        a2.name="rohit";
        a2.cgpa=6.78;


        a1.printdetailes();
        a2.printdetailes();

    }
}
