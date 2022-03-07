package GenSpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        var test = new Human(3,2);
        assertNotNull(test.toString(), "Expected \uD83E\uDD77");
    }
}