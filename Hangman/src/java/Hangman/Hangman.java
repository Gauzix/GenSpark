package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static final String[] WORDS = {
            "banana", "cryogenic", "vitamin", "cereal", "games",
            "halo", "destiny", "orion", "aurora", "jacket",
            "cryptic", "trials", "word", "trick", "war",
            "tour", "band", "arrow", "critical", "role", "time",
            "giant", "dragon", "adventure", "loser", "cry", "ride",
            "ant", "elephant", "stream"
    };

    public static final Random RANDOM = new Random();
    public static final int MAX_ERRORS = 7;
    public Scanner input = new Scanner(System.in);
    private String wordToFind;
    private char[] lettersFound;
    private int errors;
    private ArrayList< String > letters = new ArrayList< >();

    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
    public void newGame() {
        errors = 0;
        letters.clear();
        wordToFind = nextWordToFind();
        lettersFound = new char[wordToFind.length()];

        for (int i = 0; i < lettersFound.length; i++) {
            lettersFound[i] = '_';
        }
    }

    public boolean wordFound() {
        return wordToFind.contentEquals(new String(lettersFound));
    }
    private void enter(String c) {
        if (!letters.contains(c)) {
            if (wordToFind.contains(c)) {
                int index = wordToFind.indexOf(c);
                while (index >= 0) {
                    lettersFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                errors++;
            }
            letters.add(c);
        }
    }
    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lettersFound.length; i++) {
            builder.append(lettersFound[i]);
            if (i < lettersFound.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
    public void playGame() {
        try {
            while (errors < MAX_ERRORS) {
                System.out.println("\nEnter a letter : ");
                String str = input.next();

                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }
                enter(str);
                System.out.println("\n" + wordFoundContent());
                if (wordFound()) {
                    System.out.println("\nCongratulations! You Won! \n" +
                            "The trolls grumble and fuss, but honor their word. \n" +
                            "You're free, but do you want to challenge them again? (yes or no)");
                    String cont = input.next();
                    cont = cont.toLowerCase();
                    try {
                        if (cont.equals("yes")) {
                            System.out.println("The trolls are surprised but gladly agree.");
                            newGame();
                        } else if (cont.equals("no")) {
                            System.out.println("\nYou decide to leave, good choice. \n" +
                                    "You continue your adventure. \n" +
                                    "Stay out of trouble this time!");
                            break;
                        }
                    } catch (Exception p) {
                        System.out.println("Invalid input. Enter 'yes' or 'no' \n" +
                                "Ending game");
                    }
                } else {
                    System.out.println("\n=> No.of tries remaining : " + (MAX_ERRORS - errors));
                }
                hangmanImage();
            }

        } catch (Exception e){
            System.out.println("Invalid input, enter a letter");
        }
    }

    public void hangmanImage() {
        if (errors == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (errors == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (errors == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (errors == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (errors == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (errors == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (errors == MAX_ERRORS) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("\nAs you make your final guess, \n" +
                    "the trolls seize you. Your final guess was wrong!\n" +
                    "The trolls throw you off the nearby cliff. \n" +
                    "You died! Would you like to resurrect and try to win again? (yes or no)");
            System.out.println("=> The word of the game was : " + wordToFind);
            String cont = input.next();
            cont = cont.toLowerCase();
            try {
                if (cont.equals("yes")) {
                    System.out.println("\nTime rewinds to the start of the game.");
                    newGame();
                } else if (cont.equals("no")) {
                    System.out.println("\nBetter luck next time!");
                }
            } catch (Exception i){
                System.out.println("Invalid input. Enter 'yes' or 'no' \n" +
                        "Ending game");
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("After having passed the dragon's cave in one piece, \n" +
                "you exit the mountains only to be seized by trolls! \n" +
                "Luckily for you, trolls love games!\n" +
                "You convince them to play one to win your freedom. \n" +
                "The catch, if you lose they'll kill you! \n" +
                "The trolls choose hangman for the game. \n" +
                "How bad could it be, trolls can't have that good of a vocabulary right?");
        Hangman hangmanGame = new Hangman();
        hangmanGame.newGame();
        hangmanGame.playGame();
    }

}
