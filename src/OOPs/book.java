package OOPs;

class main {
    static int totalBooks;
    String title;
    String auther;
    String isbn;
    boolean isborrowed;
    static{
        totalBooks=0;
    }
    {
        totalBooks++;
    }
    main(String title,String auther,String isbn){
        this.title=title;
        this.auther=auther;
        this.isbn=isbn;
    }
    main(String isbn){
        this(isbn,"unknown","unknown");
    }
    static int getTotalBooks(){
        return totalBooks;
    }
    void borrowBook(){
        if(isborrowed) System.out.println("book is already borrowed");
        else {
            this.isborrowed=true;
            System.out.println("enjoy the book : "+title);
        }
    }
    void returnbook(){
        if(isborrowed) {
            this.isborrowed=false;
            System.out.println("hope you enjoyed, please leave a review");
        }
        else {
            System.out.println("this book is already in the library");
        }
    }
}

public class book{
    public static void main(String[] args) {
        main obj = new main("1","aetomic habits","darshil prajapati");
        main obj2 = new main("2");
        System.out.println(main.getTotalBooks());
        obj.borrowBook();
        obj2.borrowBook();
        obj.borrowBook();
        obj.returnbook();
        obj.borrowBook();
        obj2.returnbook();
        obj.returnbook();
        obj2.returnbook();
    }
}

