package GenSpark;

public class Human extends Humanoid{
    public Human(int x , int y) {
        this.setX(x);
        this.setY(y);

        this.setAttack(5);
        this.setDefense(5);
        this.setHealth(10);
    }

    @Override
    public String toString() {
        return "\uD83E\uDD77";
    }
}
