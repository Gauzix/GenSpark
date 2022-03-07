package GenSpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var map = new Map(10);
        var goblin = new Goblin(5 , 5);
        var goblin2 = new Goblin(1 , 5);
        var player = new Human(3 , 2);
        map.addEntity(player);
        map.addEntity(goblin);
        map.addEntity(goblin2);
        map.updateState();
        System.out.println("Welcome to Humans vs Goblins!\n" +
                            "You control \uD83E\uDD77, a simple adventurer for now.\n" +
                            "Clear the forests of Goblins(\uD83D\uDC79) to protect the village people!\n" +
                            "Choose a direction to move using w,a,s,d(up,left,down,right), combat starts when you share a space with a goblin.");
        System.out.println(map);
        Scanner userInput = new Scanner(System.in);

        int playerHealth = player.getHealth();
        while (playerHealth > 0) {
            try{
                String direction = userInput.nextLine();
                player.movement(direction);
                map.updateState();
                System.out.println(map);
                if (player.getX() == goblin.getX() && player.getY() == goblin.getY()){
                    Combat combat = new Combat(player,goblin);
                    if (combat.outcome()){
                        map.removeEntity(player);
                    } else if (!combat.outcome()){
                        map.removeEntity(goblin);
                    }
                } else if (player.getX() == goblin2.getX() && player.getY() == goblin2.getY()){
                    Combat combat = new Combat(player,goblin2);
                    if (combat.outcome()){
                        map.removeEntity(player);
                    } else if (!combat.outcome()){
                        map.removeEntity(goblin2);
                    }
                }
                if (goblin.getHealth() <= 0 && goblin2.getHealth() <= 0){
                    System.out.println("\nYou killed all the goblins, the villagers are safe!\n" +
                            "Thank you brave adventurer!");
                    playerHealth = 0;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, enter one of the following: w,a,s,d");
            }

        }
    }

}
