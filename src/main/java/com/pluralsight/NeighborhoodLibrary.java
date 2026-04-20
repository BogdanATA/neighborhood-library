package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static Book[] books = new Book[20];

    private static int numBooks = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //list of initialized books
        books[0] = new Book(1, "9781402894626", "The Potato Harvest", false, "");
        books[1] = new Book(2, "9780545010221", "Beneath the Potato Fields", false, "");
        books[2] = new Book(3, "9781861978769", "A History of the Humble Potato", false, "");
        books[3] = new Book(4, "9780743273565", "The Farmer’s Guide to Potatoes", false, "");
        books[4] = new Book(5, "9781250306983", "Secrets of the Golden Spud", false, "");
        books[5] = new Book(6, "9780316769480", "The Potato Kingdom", false, "");
        books[6] = new Book(7, "9781984876542", "From Soil to Supper: The Potato Story", false, "");
        //end of list

        //run loop until user exits
        boolean isDone = false;
        while (!isDone) { // will run until isDone is set to true

            //print out home screen
            System.out.println("\n === Home Screen ===");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Exit");

            //read user input on home screen
            int command = scanner.nextInt();
            scanner.nextLine();

            //switch statement to open menu that user selected
            switch(command) {
                case 1:
                    showAvailableBooks(scanner);
                    break;
                case 2:
                    showCheckedOut(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
    //list all currently available books in the library
    public static void showAvailableBooks(Scanner scanner){
        System.out.println("Book Inventory:");
        System.out.println("---------------");
        //shows all the available books
        for (int i = 0; i < numBooks; i++) {
            if (!books[i].isCheckedOut()) { //if book isnt checked out print the book
                System.out.println(books[i]);
            }
        }
        //ask if they want to check out a book
        boolean isDone = false;
        while (!isDone) { // will run until isDone is set to true
            System.out.println("\nDo you want to check out a book");
            System.out.println("1) to check out a book");
            System.out.println("2) to exit");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case 1:
                    //if 1 prompt for their name and id of book
                    checkOutBook(scanner);
                    isDone = true;
                    break;
                case 2:
                    //if 2 exit to home screen
                    System.out.println("Goodbye!");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;

            }

        }

    }

    //show checked out books / and ask if they want to check in a book
    public static void showCheckedOut(Scanner scanner){
        System.out.println("List of Checked Out Books:");
        System.out.println("--------------------------");
        //show book if CheckedOut = true
        for (int i = 0; i < numBooks; i++) {
            if(books[i].isCheckedOut()) {
                System.out.println(books[i]);
            }
        }
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nWould you like to check in a book?");
            System.out.println("(C) check in a book");
            System.out.println("(X) go back to homescreen");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command){
                case "C":
                    //c to check in a book
                    checkInBook(scanner);
                    break;
                case "X":
                    //x go back to homescreen
                    System.out.println("GoodBye! ");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    //called by showCheckedOut to check in a book
    public static void checkInBook(Scanner scanner){
        //get ID of book that user wants to check in
        System.out.println("What is the ID of the book you want to check in?");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numBooks; i++) {
            if (books[i].getId() == bookId) {
                if (books[i].isCheckedOut()) { //can only check in book if it is checked out
                    books[i].checkIn(); //update checkedOutTo name to "" and update isCheckedOut to false
                    System.out.println("Thank you, this book was successfully checked in.");
                } else {
                    System.out.println("Book is either already checked in or the ID does not match a book in our system.");
                }
                return; //bring user back to screen asking if he wants to check in book
            }
        }
    }

    //called by showAvailableBooks to check out a book
    public static void checkOutBook(Scanner scanner){
        //enter your name and id number of book you are checking out
        System.out.println("What is your name: ");
        String name = scanner.nextLine();

        System.out.println("what is the book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        //check if ID entered is a real ID, if it is check out that book
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getId() == bookId){
                if (!books[i].isCheckedOut()) { // cannot check out book if isCheckedOut is already true
                    books[i].checkOut(name); //update checkedOutTo to the name entered and update isCheckedOut to true
                    System.out.println("Thank you " + name + ", book is successfully checked out.");
                } else {
                    System.out.println("That book is unavailable.");
                }

            }
        }

    }


}
