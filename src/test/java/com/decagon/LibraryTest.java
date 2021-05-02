package com.decagon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library = new Library();
    Person teacher = new Person("Adekunle Gold", "Teacher", 2342);
    Person seniorStudent = new Person("Paul", "Senior Student", 334);
    Person juniorStudent = new Person("Khan", "Junior Student", 3463);
    Book book = new Book("The man", "John Marsden", 23434, "2020");


    @Test
    void getTheQueue() {
        library.queueMember(teacher, library.queueService);
        String name = teacher.getName();
        assertTrue(name.equalsIgnoreCase("Adekunle Gold"));

    }

    @Test
    void getBooksCatalog() {
        library.bookAdding(book, library.bookService);
        String name = book.getAuthor();
        assertTrue(name.equalsIgnoreCase("John Marsden"));
    }

    @Test
    void borrowBook() {
        library.queueMember(juniorStudent, library.queueService);
        library.queueMember(teacher, library.queueService);
        library.bookAdding(book, library.bookService);
        library.bookAdding(book, library.bookService);
        assertTrue(library.getTheQueue().size()==2);
    }

    @Test
    void putUserInQueue() {
        library.queueMember(juniorStudent, library.queueService);
        library.queueMember(seniorStudent, library.queueService);
        assertTrue(library.getTheQueue().size()==2);

    }
}
