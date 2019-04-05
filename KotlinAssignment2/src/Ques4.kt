fun main(args: Array<String>) {
    println("Welcome TO Library Management System")
    val library = Library()

//    library.issueBook("Science", "Student")
    library.issueBook("Technology","Teacher")
    println("Thanks for using Library Management System")
}

class Library : Book() {
    fun issueBook(genre: String, borrower: String) {
        setGenre(genre)
        if (borrower == "Student")
            println(
                "Book issued to" + borrower + "for" + Student().setBorrowPeriod() + "days" +
                        "successfully by:" + setIssuer()
            )
        else
            println(
                ("Book issued to " + borrower + " for " + Teacher().setBorrowPeriod() + " days " +
                        "successfully by: " + setIssuer())
            )
    }
}

abstract class Book {
    private var genre: String? = null
    fun setGenre(genre: String) {
        this.genre = genre
    }

    fun setIssuer(): String {
        if (genre == "Science") {
            return "TTN Science Library"
        }else if(genre == "Technology"){
            return "TTN Technology Library"
        }else{
            return "Central Libaray"
        }

    }
    class Student:BookBorrower{
        override fun setBorrowPeriod(): Int {
            return 7
        }


    }
    class Teacher:BookBorrower{
        override fun setBorrowPeriod(): Int {
            return 14
        }

    }
    interface BookBorrower{
        fun setBorrowPeriod():Int
    }

}