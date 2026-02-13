package OOPs;
import java.util.Scanner;
interface client{
    void input();
    void output();
}

class InterFace implements client {
    String name;
    int salary;
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name : ");
        name = sc.nextLine();
        System.out.println("enter salary");
        salary = sc.nextInt();
    }
    public void output(){
        System.out.println(name+" "+salary);
    }

    static void main(String[] args) {
        client r = new InterFace();
        r.input();
        r.output();
    }
}
