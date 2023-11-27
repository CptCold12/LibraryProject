package BookManagement;
import People.*;

import java.time.LocalDate;

public class Book implements Management {

    private boolean borrowed = false;
    private long UUID;
    private String name;
    private int timeBorrowed;
    public long holderUUID;
    private String genre;
    private LocalDate returnDate;
    private LocalDate currentDate = LocalDate.now();


    public Book (String name, long UUID, String genre){
        this.UUID = UUID;
        this.genre = genre;
        this.name = name;


    }

    public int fine(Person person){
        int fineAmount;
        if(holderUUID != person.getUUID()) {
            System.out.println("This person has not borrowed this book");
            fineAmount = 0;
        }else if (timeBorrowed > person.getRetTime()){
            fineAmount = 3*(timeBorrowed - person.getRetTime());


        }else{
            fineAmount = 0;
        }

        return fineAmount;
    }

    public void Loan(Person person) {
        if (borrowed == true){
            System.out.println("This book is already borrowed, and will likely be returned on " + returnDate);
        } else{
            holderUUID = person.getUUID();
            borrowed = true;
            returnDate = currentDate.plusDays(person.getRetTime());
            System.out.println("This book has been succesfully borrowed and needs to be returned on " + returnDate);

        }
    }

    public void itemReturn(Person person){
        if (borrowed == false){
            System.out.println("This book is not borrowed");

        } else if (holderUUID != person.getUUID()) {
            System.out.println("You do not currently hold this book");

        } else{

            borrowed = false;
            if (currentDate.isAfter(returnDate)){
                int myFine = fine(person);
                System.out.println("This book has been succesfully returned with fine " + myFine);
            }else{
                System.out.println("This book has been succesfully returned with no fine");
            }
            holderUUID = 0;
        }
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public int getTimeBorrowed() {
        return timeBorrowed;
    }

    public void setTimeBorrowed(int timeBorrowed) {
        this.timeBorrowed = timeBorrowed;
        this.currentDate = this.currentDate.plusDays(timeBorrowed);
    }

    public long getUUID() {
        return UUID;
    }

    public String getGenre(){
        return genre;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReturnDate() {
        if (borrowed == false) {
            System.out.println("book not borrowed");
            return null;
        } else {
            return returnDate;
        }
    }
}
