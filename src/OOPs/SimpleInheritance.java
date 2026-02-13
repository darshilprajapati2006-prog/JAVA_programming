package OOPs;
class Si{
   int rollNo;
   String name;
   double marks;
   void input()
   {
        System.out.println("enter rollNo , name and marks : ");
   }
}

public class SimpleInheritance extends Si {
    void display(){
        rollNo=7;
        name="darshil";
        marks=7.7;
        System.out.println(rollNo+" "+name+" "+marks);
    }

    static void main(String[] args) {
        SimpleInheritance r = new SimpleInheritance();
        r.input();
        r.display();
    }
}
