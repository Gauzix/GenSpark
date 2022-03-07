package GenSpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    @Test
    void testToString() {
        var test = new Goblin(5,5);
        assertNotNull(test.toString(), "Expected \uD83D\uDC79");
    }
}