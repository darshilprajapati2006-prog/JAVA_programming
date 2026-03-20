package mid_exam;

class Date
{

    int month;
    int day;
    int year;

    // Constructor
    Date(int m,int d,int y)
    {
        month = m;
        day = d;
        year = y;
    }

    // Setters

    public void setMonth(int m)
    {
        month = m;
    }

    public void setDay(int d)
    {
        day = d;
    }

    public void setYear(int y)
    {
        year = y;
    }

    // Getters

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }

    // Display Date

    public void displayDate()
    {
        System.out.println(month + "/" + day + "/" + year);
    }

}

public class p10
{
    public static void main(String args[])
    {

        Date d1 = new Date(5,25,2025);

        System.out.println("Date is:");

        d1.displayDate();

    }
}