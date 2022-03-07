package GenSpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanoidTest {

    @Test
    void movement() {
        Humanoid humanoid = new Humanoid();
        assertEquals("GenSpark.Humanoid", humanoid.movement("a").getClass().getName(), "Expected return of object for next movement.");
    }
}