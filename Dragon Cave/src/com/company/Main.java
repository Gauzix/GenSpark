package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("You are in a land full of dragons.\n" +
                "In front of you, you see two caves.\n" +
                "In one cave, the dragon is friendly and will share his treasure with you.\n" +
                "The other dragon is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");

        String userInput = input.nextLine();


        if (userInput.equals("1")) {
            System.out.println();
            System.out.println("You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "Gobbles you down in one bite!");
        } else if (userInput.equals("2")) {
            System.out.println("You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon approaches you! He opens his jaws and...\n" +
                    "Offers to share his gold with you!\n" +
                    "You receive 1000 gold pieces!");
        } else {
            System.out.println();
            System.out.println("You didn't go in a cave...\n" +
                    "A goblin sneaks up behind you and stabs you...a lot...\n" +
                    "Start over and please enter either 1 or 2. For your sake.");
        }

        input.close();
    }
}
