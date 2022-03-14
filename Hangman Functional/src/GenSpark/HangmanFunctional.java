package GenSpark;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HangmanFunctional {

    public static String[] words = {
        "banana", "cryogenic", "vitamin", "cereal", "games",
                "halo", "destiny", "orion", "aurora", "jacket",
                "cryptic", "trials", "word", "trick", "war",
                "tour", "band", "arrow", "critical", "role", "time",
                "giant", "dragon", "adventure", "loser", "cry", "ride",
                "ant", "elephant", "stream"
    };

    public static String word = words[(int) (Math.random() * words.length)];
    public static CorrectGuesses correctGuesses = new CorrectGuesses(word);
    public static String base = new String(new char[word.length()]).replace("\0", "-");
    public static int count = 0;
    public static Scanner scan = new Scanner(System.in);
    public static String newBase = "";
    public static char userAnswer;
    public static String missedLetters = "";
    public static String guess;
    public static String repeatMessage;
    public static int countCorrect;
    public static int countRepeat;
    public static int countBaseRepeat;
    public static String playerName;



    public static void main(String[] args) {
        do {
            System.out.print("HANGMAN\n" +
                    "What is your name?");
            playerName = scan.nextLine();

            try{
                FileWriter names = new FileWriter("scores.csv",true);
                BufferedWriter out = new BufferedWriter(names);
                out.write(playerName + ", ");
                out.close();
                System.out.println("\nSuccessfully recorded your name.\n");
            }catch (Exception e){
                System.out.println("Issue writing name to file.");;
            }

            count = 0;
            missedLetters = "";
            String newWord = words[(int) (Math.random() * words.length)];
            word = newWord;
            correctGuesses = new CorrectGuesses(word);

            base = Arrays.stream(Arrays.stream(word.split(""))
                            .map(s -> "-")
                            .toArray(String[]::new))
                    .collect(Collectors.joining());

            gameCount();
            Scores.totalWins();
            System.out.println("Do you want to play again? (y or n)");
            userAnswer = scan.next().charAt(0);
            if (userAnswer == 'n') {
                System.out.println("\n + Thanks for playing!");
                break;
            }
        } while (userAnswer == 'y');
    }

    private static void gameCount() {
        do {
            hangmanImage();
            int guessesRemaining = 7 - count;
            System.out.println("You've got " + guessesRemaining + " guesses Remaining.");

            try {
                System.out.println("Guess a letter.");
                System.out.println(base);
                guess = scan.next();
                correctGuesses.addGuess(guess);
                death(guess);
            } catch (Exception e) {
                System.out.println("Please enter a letter.");
            }

            repeatMissedLetters(guess);
            repeatMessage();
            wrongGuess(guess);
            underlineCheck(guess);
            underlineCheckMessage();

        } while (count < 7 && base.contains("-"));
    }

    public static void death(String guess) {
        newBase = Arrays.stream(Arrays.stream(word.split(""))
                        .map(s -> {
                            if (correctGuesses.correctLetter(s)) {
                                return s;
                            } else {
                                return "-";
                            }
                        }).toArray(String[]::new))
                .collect(Collectors.joining());

        if (base.equals(newBase)) {
            count++;
            hangmanImage();
        } else {
            base = newBase;
        }

        if (base.equals(word)) {
            System.out.println("Congrats you got the answer correct! The word was " + word);

            int score = 1;
            try{
                FileWriter recordScore = new FileWriter("scores.csv",true);
                BufferedWriter out = new BufferedWriter(recordScore);
                out.write(score + "\n");
                out.close();
                System.out.println("\nWin added to your score.\n");
            }catch (Exception e){
                System.err.println("Error while writing to file: " +
                        e.getMessage());
            }
        }
    }

    public static void wrongGuess(String guess) {
        if (correctGuesses.correctLetter(guess)) {
            countCorrect = 1;
        }
        if (countCorrect == 0) {
            if (countRepeat == 0 ) {
                missedLetters = missedLetters + guess.charAt(0);
            } else {
                repeatMessage = "You have already guessed that letter. Choose again.\n";
            }
        }
    }

    public static void underlineCheck (String guess) {
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) == guess.charAt(0))
                countBaseRepeat++;
        }
    }

    public static void underlineCheckMessage () {
        if (countBaseRepeat > 0) {
            repeatMessage = "You have already guessed that letter. Choose again.\n";
        }
    }

    public static void repeatMissedLetters (String guess) {
        if (missedLetters.contains(guess)) {
            countRepeat = 1;
        }
    }

    public static void repeatMessage() {
        if (countRepeat == 0) {
            repeatMessage = "";
        } else {

        }
    }

    public static <StackPane, Scene> void hangmanImage() {
        if (count == 0) {
            String fileName = "src/images/stand.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);
            System.out.println("Missed letters" + ": " + missedLetters + "\n");
        }

        if (count == 1) {
            String fileName = "src/images/stand.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);
            System.out.println("Missed letters" + ": " + missedLetters + "\n" + repeatMessage);
        }

        if (count == 2) {
            String fileName = "src/images/1.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);

            System.out.println("Missed letters" + ": " + missedLetters + "\n" + repeatMessage);
        }

        if (count == 3) {
            String fileName = "src/images/2.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);

            System.out.println("Missed letters" + ": " + missedLetters + "\n" + repeatMessage);
        }

        if (count == 4) {
            String fileName = "src/images/3.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);

            System.out.println("Missed letters" + ": " + missedLetters + "\n" + repeatMessage);
        }

        if (count == 5) {
            String fileName = "src/images/4.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);

            System.out.println("Missed letters" + ": " + missedLetters + "\n" + repeatMessage);
        }

        if (count == 5) {
            String fileName = "src/images/5.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);

            System.out.println("Missed letters" + ": " + missedLetters + "\n" + repeatMessage);
        }

        if (count == 7) {
            String fileName = "src/images/6.jpeg";
            ImageIcon icon = new ImageIcon(fileName);
            JLabel label = new JLabel(icon);
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(new JScrollPane(label));
            f.setSize(400, 400);
            f.setLocation(200, 200);
            f.setVisible(true);

            System.out.println("Game Over! The secret word was " + "\"" + word + "\"" + "!");
            int score = 0;

            try {
                FileWriter recordScore = new FileWriter("scores.csv", true);
                BufferedWriter out = new BufferedWriter(recordScore);
                out.write(score + "\n");
                out.close();
                System.out.println("\nSuccessfully recorded you score.\n");
            } catch (Exception e) {
                System.err.println("Error while writing to file: " +
                        e.getMessage());
            }

        }
    }
}
