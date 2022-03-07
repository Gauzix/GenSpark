package GenSpark;

public class Humanoid {
    int x , y , health , attack , defense;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    private void validMove(){
        if (x >= Map.dimensions - 1){
            this.x = Map.dimensions - 1;
        } else if (x < 0){
            this.x = 0;
        }

        if (y >= Map.dimensions - 1){
            this.y = Map.dimensions - 1;
        } else if (y < 0){
            this.y = 0;
        }
    }

    public Humanoid movement(String move) {
        validMove();
        switch (move) {
            case "w" -> this.setX(x - 1);
            case "s" -> this.setX(x + 1);
            case "a" -> this.setY(y - 1);
            case "d" -> this.setY(y + 1);
        }
        return this;
    }
}
