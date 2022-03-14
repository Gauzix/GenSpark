package GenSpark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Scores {
    public static int totalWins = 0;
    public static int wins = 0;
    public static int gameNumber = 0;
    public static double winPercentage = 0;
    public static int winPercentageFinalValue = 0;

    public static void totalWins() {
        System.out.println(HangmanFunctional.playerName + ", show your score? (y or n)");
        Scanner answer = new Scanner(System.in);
        String userAnswer = answer.nextLine();

        if (userAnswer.charAt(0) == 'y') {
            String path = "/Users/robin/Documents/Programming/IntelliJ/Class Projects/Hangman Functional/scores.csv";
            String line = "";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));

                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(", ");
                    String currentName = values[0];

                    if (currentName.equals(HangmanFunctional.playerName)) {
                        wins = Integer.parseInt(values[1]);
                        totalWins = totalWins + wins;
                        gameNumber++;
                    }
                }

                winPercentage = ((double)totalWins / (double)gameNumber) * 100;
                winPercentageFinalValue = (int)winPercentage;

                System.out.println("You have won " + totalWins + " out of " + gameNumber + " games!");
                System.out.println("Your win percentage is " + winPercentageFinalValue + "%.\n");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (userAnswer.charAt(0) == 'n') {
            System.out.println("Maybe, next time!");
        }else {
            System.out.println("Please enter 'y' or 'n'");
        }
    }
}
