package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int min = 1;
        int max = 20;
        int hiddenNumber = rand.nextInt(max - min + 1) + min;
        int guessCount = 0;
        int userNum;
        String cont = "y";
        String userCont = "";

        System.out.println("Hello! What is your name?");
        String name = input.nextLine();
        System.out.println("\n" +
                "Well, " + name + ", I am thinking of a number between 1 and 20.\n" +
                "Take a guess.");

        do {
            userNum = input.nextInt();
            guessCount++;

            //testing if number of guesses is higher than 6 after every loop
            if (guessCount > 6) {
                System.out.println("\n" +
                        "You lost!\n" +
                        "You didn't guess my number in six tries. \n" +
                        "Would you like to play again? (y or n)");
                userCont = input.next();

                if (userCont.equals(cont)) {
                    guessCount = 0;
                    hiddenNumber = rand.nextInt(max - min + 1) + min;
                    System.out.println("\n" +
                            "Take a guess.");
                }else {
                    System.out.println("\n" +
                            "Thank you for playing!");
                    break;
                }
            }

            //If not over 6 guesses, game continues
            if (userNum > max || userNum < min){
                System.out.println("\n" +
                        "Please choose a number between " + min + " and " + max + ".\n" +
                        "Take a guess.");
            } else if(userNum > hiddenNumber) {
                System.out.println("\n" +
                        "Your guess is too high\n" +
                        "Take a guess.");
            }else if (userNum < hiddenNumber) {
                System.out.println("\n" +
                        "Your guess is too low\n" +
                        "Take a guess.");
            }else {
                System.out.println("\n" +
                        "Good job, " + name + "! You guessed my number in " + guessCount + " guesses!\n" +
                        "Would you like to play again? (y or n)");
                userCont = input.next();
                if (userCont.equals(cont)){
                    guessCount = 0;
                    hiddenNumber = rand.nextInt(max - min + 1) + min;
                    System.out.println("\n" +
                            "Take a guess.");
                }else {
                    System.out.println("\n" +
                            "Thank you for playing!");
                }
            }

        } while (userNum != hiddenNumber);

    }

    }

