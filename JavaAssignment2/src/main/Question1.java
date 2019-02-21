package main;

public class Question1 {
    /*
        Create Java classes having suitable attributes for Library management system.
        Use OOPs concepts in your design.Also try to use interfaces and abstract classes.
    */
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("Welcome to Library Management System");
        library.issueBook("Science", "Student");
        //Assuming that a student makes a request to book of Science genre
        System.out.println("Thanks for using Library Management System");
    }
}

class Library extends Book {
    void issueBook(String genre, String borrower) {
        setGenre(genre);
        if (borrower.equals("Student"))
            System.out.println("Book issued to " + borrower + " for " + new Student().setBorrowPeriod() + " days " +
                    "successfully by: " + setIssuer());     //
        else
            System.out.println("Book issued to " + borrower + " for " + new Teacher().setBorrowPeriod() + " days " +
                    "successfully by: " + setIssuer());
    }
}


abstract class Book {
    //this class is made abstract since we don't want library users know about the process of book issuing.
    private String genre;

    void setGenre(String genre) {
        this.genre = genre;     //setting genre for request
    }

    String setIssuer() {

        if (genre.equals("Science"))        //setting issuer of book according the genre
            return "TTN Science Library";
        else if (genre.equals("Technology"))
            return "TTN Technology Library";
        else
            return "Central Library";
    }

}

class Student implements BookBorrower {
    //customizing book borrower's details according Student
    @Override
    public int setBorrowPeriod() {
        return 7;   //setting borrow period of 7 days for Teacher
    }
}

class Teacher implements BookBorrower {
    //customizing book borrower's details according Teacher
    @Override
    public int setBorrowPeriod() {
        return 14;  //setting borrow period of 14 days for Teacher
    }
}

interface BookBorrower {
    //Interface BookBorrower is used as a skeleton for BookBorrower's details
    int setBorrowPeriod();      //method to set the borrow period
}
