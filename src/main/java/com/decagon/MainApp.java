package com.decagon;

public class MainApp {
    public static void main(String[] args) {

        /**
         *  Implementation
         */
        Library library = new Library("fifo");


        /**
         * The people available to borrow book
         */
        Person teacher = new Person("Adekunle Gold", "TEACHING STAFF", 0052);
        Person seniorStudent = new Person("John Fabregas", "STUDENT STUDENT", 0222);
        Person juniorStudent = new Person("Joshua Kimiche", "JUNIOR STUDENT", 0123);


        /**
         * Books to be added to the Library
         */
        Book book1 = new Book("\"The Night Is for Hunting\"", "John Marsden", 332121222, "2000");
        Book book2 = new Book("\"Touch Of Love\"", "Maria V. Snyder", 457358480, "192");
        Book book3 = new Book("\"The Red Sparrow\"", "Jason Matthews", 457358480, "2012");
        Book book4 = new Book("\"I Hunt Killer\"", "Barry Lyga", 45758480, "2020");
        Book book5 = new Book("\"Agent Of The Stars\"", "Don Richardson", 45735880, "1998");

        /**
         * to add book to  the catalogue.
         */

        System.out.println("*".repeat(55));
        System.out.println("\t\t\tSUCCESSFULLY ADDED BOOKS");
        System.out.println("*".repeat(55));
        library.bookAdding(book1, library.bookService);
        library.bookAdding(book2, library.bookService);
        library.bookAdding(book3, library.bookService);
        library.bookAdding(book4, library.bookService);
        library.bookAdding(book5, library.bookService);
        System.out.println("*".repeat(55));

        /**
         *  placing people on the Queue.
         */
        library.queueMember(seniorStudent, library.queueService);
        library.queueMember(teacher, library.queueService);
        library.queueMember(juniorStudent, library.queueService);


        /**
         * This prints or shows the people on the Queue.
         * and if nobody is in the Queue, it indicates "The Queue is empty"
         */
        library.queueUnit.printTheQueue();


        /**
         * to give out the book to people on the Queue, there must be book  available to give and
         * also people must be on the Queue
         */

        System.out.println("\n");
        System.out.println("*".repeat(80));
        System.out.println("\t\t\t\t\t\t\tBORROWED BOOK");
        System.out.println("*".repeat(80));
        System.out.println(library.bookProcess.borrowBook(book1));
        System.out.println(library.bookProcess.borrowBook(book2));
        System.out.println(library.bookProcess.borrowBook(book3));



        /**
         * This is shows the record of books borrowed and the name of the borrower
         */
        System.out.println("\n");
        System.out.println("*".repeat(50));
        System.out.println("\t\tRECORDS OF THE BOOKD GIVEN OUT");
        System.out.println("*".repeat(50));
        System.out.println(Library.bookRecords);
        System.out.println("*".repeat(50));

        /**
         /* to show display the list of books, to show this there must be people on the Queue
         but the book must not have been borrowed
         */

        library.catalogOfBook.showListOfBooks();



    }
}