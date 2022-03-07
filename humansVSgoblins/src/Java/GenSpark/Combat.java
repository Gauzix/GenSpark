package GenSpark;

public class Combat {
    private Humanoid player;
    private Humanoid enemy;

    public Combat (Humanoid player , Humanoid enemy) {
        this.player = player;
        this.enemy = enemy;
    }
        public boolean outcome() {
            int playerAttack = player.getAttack(), enemyAttack = enemy.getAttack();
            int playerDefense = player.getDefense(), enemyDefense = enemy.getDefense();
            int damage;
            boolean result = true;

            while (player.getHealth() > 0) {
                if (playerAttack >= enemyDefense) {
                    damage = (playerAttack + ((int)Math.random() * 5) + 1);
                    enemy.setHealth(enemy.getHealth() - damage);
                    System.out.println("You dealt " + damage + " damage to the enemy!");
                    if (enemy.getHealth() <= 0) {
                        System.out.println("You defeated the enemy!");
                        result = false;
                        break;
                    } else {
                        System.out.println("Remaining enemy health: " + enemy.getHealth());
                    }
                } else if (enemyAttack >= playerDefense) {
                    damage = (enemyAttack + ((int)Math.random() * 3) + 1);
                    player.setHealth(player.getHealth() - damage);
                    System.out.println("You were dealt " + damage + " damage!");
                    if (player.getHealth() <= 0) {
                        System.out.println("You lost in combat and died!");
                        result = true;
                        break;
                    } else {
                        System.out.println("Remaining health: " + player.getHealth());
                    }
                }
            }
            return result;
        }
}
