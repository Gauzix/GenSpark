package genSpark;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    static Scanner input = new Scanner(System.in);
    static String cont = "y";
    static String userCont;
    static int guessCount;
    static int userNum;
    static int maxGuesses = 6;
    static int userInput;
    static int min = 1;
    static int max = 20;
    static boolean game = true;

    public static String inputName(){
        System.out.println("Hello! What is your name?");
        String name = input.nextLine();
        return name;
    }

    public static int generateNum() {
        Random rand = new Random();
        int randNumber = rand.nextInt(max - min + 1) + min;
        return randNumber;
    }

    public static String playAgain(String userCont) {
        try {
            if (userCont.equals(cont)) {
                guessCount = 0;
                game = true;
                return "Same rules, let's go again!";
            } else {
                game = false;
                System.out.println("Thank you for playing!");
                return "Scared you'd lose?";

            }
        } catch (Exception i) {
            System.out.println("Invalid input. Please type 'y' or 'n'.");
        }
        return null;
    }

    public static void main(String[] args) {
            String userName = inputName();
            System.out.println("Well, " + userName + ", I am thinking of a number between 1 and 20.");
            int hiddenNumber = generateNum();

        while (game) {
            try {
                guessCount++;

                if (guessCount <= maxGuesses) {
                    System.out.println("Take a guess.");
                }

                userNum = input.nextInt();

                if (userNum > max || userNum < min) {
                    System.out.println("\n" +
                            "Please choose a number between " + min + " and " + max + ".");
                } else if (userNum > hiddenNumber) {
                    System.out.println("\n" +
                            "Your guess is too high.");
                } else if (userNum < hiddenNumber) {
                    System.out.println("\n" +
                            "Your guess is too low.");
                } else {
                    System.out.println("\n" +
                            "Good job, " + userName + "! You guessed my number in " + guessCount + " guesses!\n" +
                            "Would you like to play again? (y/n)");
                    hiddenNumber = generateNum();
                    userCont = input.next();
                    playAgain(userCont);
                }

                if (guessCount >= maxGuesses) {

                    System.out.println("You didn't guess my number in " + maxGuesses + " guesses!\n" +
                                    "Would you like to play again? (y/n)");
                    hiddenNumber = generateNum();
                    userCont = input.next();
                    playAgain(userCont);
                }
            } catch (Exception i){
                System.out.println("Invalid input. Please enter a number from 1 to 20.");
            }
            }

        }

    }

