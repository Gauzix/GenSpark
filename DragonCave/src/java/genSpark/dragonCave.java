package genSpark;
import java.util.Scanner;

public class dragonCave {
    public static void main(String[] args){
        opening();
        System.out.println(caves(pathChoice()));
    }

    public static void opening() {
        System.out.println("You are in a land full of dragons.\n" +
                "In front of you, you see two caves.\n" +
                "In one cave, the dragon is friendly and will share his treasure with you.\n" +
                "The other dragon is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");
    }

    public static int pathChoice(){
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        try{
            userInput = input.nextInt();
        } catch (Exception e){
            System.out.println("Input wasn't 1 or 2.");
        }
        return userInput;
    }

    public static String caves(int cave){
        if (cave == 1) {
            return "You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon approaches you! He opens his jaws and...\n" +
                    "Gobbles you down in one bite!";
        } else if (cave == 2) {
            return "You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon approaches you! He opens his jaws and...\n" +
                    "Offers to share his gold with you!\n" +
                    "You receive 1000 gold pieces!";
        } else {
            return "You didn't go in a cave...\n" +
                    "A goblin sneaks up behind you and stabs you...a lot...\n" +
                    "Start over and please enter either 1 or 2. For your sake.";
        }
    }

}
