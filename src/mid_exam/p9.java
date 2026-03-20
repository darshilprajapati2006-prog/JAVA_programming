package mid_exam;

class Employee
{

    String name;
    String lastName;
    double monthlySalary;

    // Constructor
    Employee(String n,String l,double salary)
    {
        name = n;
        lastName = l;

        if(salary > 0)
            monthlySalary = salary;
        else
            monthlySalary = 0;
    }

    // Setter

    public void setMonthlySalary(double salary)
    {
        if(salary > 0)
            monthlySalary = salary;
    }

    // Getters

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public double getMonthlySalary()
    {
        return monthlySalary;
    }

}

public class p9
{
    public static void main(String args[])
    {

        Employee e1 = new Employee("Rahul","Sharma",5000);
        Employee e2 = new Employee("Amit","Patel",6000);

        // Yearly salary
        System.out.println("Employee 1 yearly salary = " + e1.getMonthlySalary()*12);
        System.out.println("Employee 2 yearly salary = " + e2.getMonthlySalary()*12);

        // 10% salary hike
        e1.setMonthlySalary(e1.getMonthlySalary()*1.10);
        e2.setMonthlySalary(e2.getMonthlySalary()*1.10);

        System.out.println("After 10% hike:");

        System.out.println("Employee 1 yearly salary = " + e1.getMonthlySalary()*12);
        System.out.println("Employee 2 yearly salary = " + e2.getMonthlySalary()*12);

    }
}
