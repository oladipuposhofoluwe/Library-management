package com.decagon;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Library{
    private Queue<Person>theQueue;
    private List<Book> booksCatalog = new ArrayList<>();
    private String type;
    public static Map<Integer, String> bookRecords = new HashMap();


    //constructor for  the "Priority based" implementation
    public  Library(){
        theQueue = new PriorityQueue<>(Comparator.comparingInt(s2 -> s2.getLevel()));
    }




    //constructor for the "First Come First Serve" implementation
    public Library(String type) {
        if(type.equalsIgnoreCase("first come first serve") || type.equalsIgnoreCase("FIFO")) {
            this.type = "first come first serve";
            theQueue = new ConcurrentLinkedQueue<>();
        }else {
            throw new NullPointerException("Invalid Priority method");
        }
    }

    public Queue<Person> getTheQueue() {
        return theQueue;
    }


//This Method borrows book from the Library
    BookBorrow bookProcess = (Book book) -> {
        if (!booksCatalog.contains(book)) {
            throw new NullPointerException("Book not available");
        } else {
            booksCatalog.remove(book);
            Person person = theQueue.poll();

            // This the Record of people jthat have the people in their possession (that is,
            // the record of the people that borrowed the book
            String bookInfo = "\n\tBook Title "+book.getTitle()+"\n\t"+"Name "+person.getName()+"\n\t"+"Position "+person.getPosition()+"\n";

            if(bookRecords.size() == 0){
                bookRecords.put(book.getIsbn(), bookInfo);
            }else{
                int tracker = 0;
                if(bookRecords.containsKey(book.getIsbn())) tracker++;

                if(tracker == 0) bookRecords.put(book.getIsbn(), bookInfo);
                else{
                    String value =  bookRecords.get(book.getIsbn());
                    value += bookInfo;
                    bookRecords.put(book.getIsbn(),value);

                }
            }
            return "The Book " + book.getTitle()+" given to the " + person.getPosition() +", " + person.getName() + ".";
        }};


//Method for the Queue services
     UserQueue queueService = (Person person) -> {
        if (theQueue.contains(person)){
            System.out.println("The person is on the queue already");
            return false;
        }else if (person != null){
            theQueue.add(person);
            return true;
        }else {
        throw new InvalidParameterException();
    } };

    public void queueMember (Person person, UserQueue queueService){
        queueService.putUserInQueue(person); }



//This method adds book to the library
    BookAdd bookService = (Book book) -> {if (book==null){
        throw new NullPointerException("Book cannot be added because its either null or has incomplete details");
    }   System.out.println("Book Title: " + book.getTitle() + ". By " + book.getAuthor());
        booksCatalog.add(book);};

    public void bookAdding (Book book, BookAdd bookService){
         bookService.addBook(book); }



//This method prints or show the people on the queue
    MainQueue queueUnit = () -> {
        if (theQueue==null)
            throw new NullPointerException("Queue is null");
        if (theQueue.size()==0) {
            System.out.println("The queue is empty");     //this shows if queue is empty
        }

        System.out.println("\n");
        System.out.println("*".repeat(80));
        System.out.println("\t\t\t\t\t\t[THE LIST OF PEOPLE ON THE QUEUE]");
        System.out.println("*".repeat(80));

        theQueue.forEach(person -> {
            System.out.println("Position: " + person.getPosition()+". "
                    + "\t\tName: " + person.getName() +". "+ "\t\tLibrary Card Number: "
                    + person.getLibraryCardNumber());     //if Queue is empty, this put people on the queue.
        });
    };

    public void Queuing () {
        queueUnit.printTheQueue();
    }



    //This method show the list book available in the library, that is, book not yet borrowed
    BookList catalogOfBook = () -> {
        System.out.println(booksCatalog);
        if (booksCatalog==null){
            throw new NullPointerException("Book list is null");
        }
        if (booksCatalog.size()==0) {
            System.out.println("*" .repeat(60));
            System.out.println("\t\t\tSORRY, THE BOOK-CATALOGUE IS EMPTY"); //This checks if their are no books in the library catalog.
            System.out.println("*" .repeat(60));
        }

        System.out.println("\n");
        System.out.println("*" .repeat(60));
        System.out.println("\t\t\t\t\t[LIST OF BOOKS]");
        System.out.println("*" .repeat(60));

        booksCatalog.forEach(book -> {
            System.out.println("Book Title: " + book.getTitle()+"." + " By: "
                    + book.getAuthor() +". " + " ISBN: " + +book.getIsbn());
        });
    };

    public void listOfBook(){
        catalogOfBook.showListOfBooks();
    }
}

