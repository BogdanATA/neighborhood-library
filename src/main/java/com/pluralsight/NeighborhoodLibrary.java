package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static Book[] books = new Book[20];

    private static int numBooks = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        books[0] = new Book(1, "9781402894626", "The Potato Harvest", true, "");
        books[1] = new Book(2, "9780545010221", "Beneath the Potato Fields", false, "");
        books[2] = new Book(3, "9781861978769", "A History of the Humble Potato", false, "");
        books[3] = new Book(4, "9780743273565", "The Farmer’s Guide to Potatoes", false, "");
        books[4] = new Book(5, "9781250306983", "Secrets of the Golden Spud", false, "");
        books[5] = new Book(6, "9780316769480", "The Potato Kingdom", false, "");
        books[6] = new Book(7, "9781984876542", "From Soil to Supper: The Potato Story", false, "");


        System.out.println(books[0]);

        //run loop until user exits
        boolean isDone = false;
        while (!isDone) {

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
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOut();
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
    //list all books in the library
    public static void showAvailableBooks(){
        System.out.println("Book Inventory:");

        for (int i = 0; i < numBooks; i++) {
            System.out.println(books[i]);
        }
    }

    //show checked out books
    public static void showCheckedOut(){
        //show book if CheckedOut = true
        for (int i = 0; i < numBooks; i++) {
            if(books[i].isCheckedOut())
            System.out.println(books[i]);
        }
    }
}
