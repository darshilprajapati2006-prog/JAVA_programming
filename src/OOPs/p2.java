package OOPs;

class Employee{

    int salary;
    String name;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setSalary(int r) {
        salary = r;
    }

    public void setname(String s){
        name = s;

    }
};

public class p2 {
    public static void main(String[] args) {
        Employee obj = new Employee();
        obj.setSalary(25000);
        obj.setname("Darshil");

        System.out.println(obj.getName());
        System.out.println(obj.getSalary());
    }
}
