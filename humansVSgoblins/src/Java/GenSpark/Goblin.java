package GenSpark;

import java.util.Random;

public class Goblin extends Humanoid{
    Random random = new Random();
    public Goblin(int x , int y) {
        this.setX(x);
        this.setY(y);

        this.setAttack(random.nextInt(1 , 5));
        this.setDefense(random.nextInt(1 , 5));
        this.setHealth(10);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC79";
    }

}
