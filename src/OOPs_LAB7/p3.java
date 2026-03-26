package OOPs_LAB7;

class Book {
    int bookId;
    String title;
    String author;
    double price;

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class Periodical extends Book {
    String period;

    Periodical(int bookId, String title, String author, double price, String period) {
        super(bookId, title, author, price);
        this.period = period;
    }

    void modifyPrice(double newPrice) {
        price = newPrice;
    }

    void modifyPeriod(String newPeriod) {
        period = newPeriod;
    }

    void displayPeriodicalDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Period: " + period);
    }
}

public class p3 {
    public static void main(String[] args) {
        Periodical p = new Periodical(101, "Science Today", "R.K. Sharma", 120.0, "Monthly");

        System.out.println("Original Periodical Details");
        p.displayPeriodicalDetails();

        p.modifyPrice(150.0);
        p.modifyPeriod("Weekly");

        System.out.println("\nUpdated Periodical Details");
        p.displayPeriodicalDetails();
    }
}
