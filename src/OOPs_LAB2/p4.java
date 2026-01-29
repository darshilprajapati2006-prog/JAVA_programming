package OOPs_LAB2;

class Date {


    private int month;
    private int day;
    private int year;


    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }


    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    // display date method
    public void displayDate() {
        System.out.println(month + "/" + day + "/" + year);
    }
}

public class p4 {

    public static void main(String[] args) {


        Date date = new Date(9, 1, 2026);


        System.out.print("Date is: ");
        date.displayDate();
    }
}