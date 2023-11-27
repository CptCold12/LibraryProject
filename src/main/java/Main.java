import BookManagement.Book;
import People.*;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Random Person", 10873493L);
        GeneralPublic pub1 = new GeneralPublic("Cameron Briginshaw", 998766522L);

        Book book1 = new Book("1984",88177396L, "Dystopian");
        Book book2 = new Book("The Elephant Vanishes", 6632637848L, "Existential");


        System.out.println("*Checking if already borrowed*");
        System.out.println(book1.isBorrowed());
        System.out.println("*Loaning to student1*");
        book1.Loan(student1);
        System.out.println("*Checking if already borrowed*");
        System.out.println(book1.isBorrowed());
        System.out.println("*Checking return date*");
        System.out.println(book1.getReturnDate());
        System.out.println("*Checking return date for already borrowed book*");
        book2.getReturnDate();
        System.out.println("*Setting time has been borrowed for*");
        book1.setTimeBorrowed(5);
        System.out.println("*Returning book1 with incorrect person*");
        book1.itemReturn(pub1);
        System.out.println("*Returning book1 with correct person*");
        book1.itemReturn(student1);
        System.out.println("-----------------BOOK CHANGE-------------------");
        System.out.println("*Loaning other book*");
        book2.Loan(pub1);
        System.out.println("*Trying to loan already loaned book*");
        book2.Loan(student1);
        System.out.println("*Setting time borrowed to exceed max hold length of person*");
        book2.setTimeBorrowed(15);
        System.out.println("*Returning book2 in time exceeding max hold length*");
        book2.itemReturn(pub1);

    }
}
