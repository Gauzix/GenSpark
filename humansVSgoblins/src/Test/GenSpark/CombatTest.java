package GenSpark;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    @org.junit.jupiter.api.Test
    void outcome() {
        Human player = new Human(3,2);
        Goblin enemy = new Goblin(5,5);
        Combat combat = new Combat(player, enemy);
        assertFalse(combat.outcome(), "Expected false, got true");
    }
}