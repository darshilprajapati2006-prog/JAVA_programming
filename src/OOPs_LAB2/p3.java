package OOPs_LAB2;

class Employee{
    private String firstname;
    private String lastname;
    private double monthlysalary;

    public Employee(String firstname,String lastname,double monthlysalary){
        this.firstname = firstname;
        this.lastname = lastname;
        if(monthlysalary>0)
            this.monthlysalary = monthlysalary;
        else
            this.monthlysalary=0.0;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setlastname(String lastname){
        this.lastname = lastname;
    }
    public String getlastname(){
        return lastname;
    }

    public void setMonthlysalary(double monthlysalary){
        if(monthlysalary>0)
            this.monthlysalary=monthlysalary;
        else
            this.monthlysalary=0.0;
    }

    public double getMonthlysalary() {
        return monthlysalary;
    }
    public double getyearlysalary() {
        return monthlysalary*12;
    }
    public void giveHike(){
        this.monthlysalary = monthlysalary+monthlysalary*0.1;
    }
}

public class p3 {
    public static void main(String[] args) {

        Employee emp1 = new Employee("darshil","prajapati",50000);
        Employee emp2 = new Employee("bharatlal","pal",45000);

        System.out.println("Before Hike:");
        System.out.println(emp1.getFirstname() + " " + emp1.getlastname() +
                " Yearly Salary = " + emp1.getyearlysalary());

        System.out.println(emp2.getFirstname() + " " + emp2.getlastname() +
                " Yearly Salary = " + emp2.getyearlysalary());


        emp1.giveHike();
        emp2.giveHike();


        System.out.println("\nAfter 10% Hike:");
        System.out.println(emp1.getFirstname()+ " " + emp1.getlastname() +
                " Yearly Salary = " + emp1.getyearlysalary());

        System.out.println(emp2.getFirstname() + " " + emp2.getlastname() +
                " Yearly Salary = " + emp2.getyearlysalary());
    }
}


