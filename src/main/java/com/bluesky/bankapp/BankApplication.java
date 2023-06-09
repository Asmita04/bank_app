package com.bluesky.bankapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Simple Bank Application
 *
 * */
public class BankApplication {

    public static void main(String[] args) {

        int choice;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to MHETRE's Bank Pvt Ltd!!");

        do {
            System.out.println("1.Register User");
            System.out.println("2.Remove Account");
            System.out.println("3.Transfer Money");
            System.out.println("4.Display List of All Accounts");
            System.out.println("5.Exit");
            System.out.println("Enter Your Choice:");
            choice = scan.nextInt();

            switch (choice) {
                case 1: {

                    System.out.println("Mock User registration!");
                    break;
                }

                case 2: {

                    System.out.println("Removing Account for the particular user!");
                    break;
                }

                case 3: {
                    System.out.println("Money transfering from one account to other!");
                    break;
                }
                case 4: {
                   // System.out.println(map);
                    System.out.println("Display all records");
                    break;
                }

                case 5: {

                    System.out.println("Exit!");
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }


        } while (choice != 5);
    }


}

