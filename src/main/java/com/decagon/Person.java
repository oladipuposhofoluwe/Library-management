package com.decagon;

//The person class.
public class Person {
    private String name;
    private String position;
    private final int teacherLevel =   1;
    private final int seniorStudentLevel = 4;
    private final int juniorStudentLevel = 7;
    private int level;
    private int libraryCardNumber;


    // Constructor for the fields particular to the borrower
    public Person(String name, String position, int libraryCardNumber) {
        this.name = name;
        this.position = position;
        this.libraryCardNumber = libraryCardNumber;
        assignLevel();
    }


    // This method assigns level of priority to the borrowers
    public void assignLevel() {
        if (this.position.equalsIgnoreCase("Teacher")) {
            this.level = teacherLevel;
        } else if (this.position.equalsIgnoreCase("Junior Student")) {
            this.level = juniorStudentLevel;
        } else if (this.position.equalsIgnoreCase("Senior Student")) {
            this.level = seniorStudentLevel;
        } else {
            this.level = -1;
        }
    }


    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public String getPosition() {
        return position;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }
}
