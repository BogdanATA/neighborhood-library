package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static Book[] books = new Book[20];

    private static int numBooks = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        books[0] = new Book(1, "12345", "How to farm potatoes", false, "");

        System.out.println(books[0]);

        //run loop until user exits
        boolean isDone = false;
        while (!isDone) {

            //print out home screen
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Exit");

            //read user input on home screen
            int command = scanner.nextInt();
            scanner.nextLine();

            //switch statement to open menu that user selected
            switch(command) {
                case 1:

                    break;
                case 2:

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
}
