import genSpark.dragonCave;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class dragonCaveTest {

    dragonCave dragon;

    @BeforeEach
    void setUp() {
        dragon = new dragonCave();
    }

    @DisplayName("Test caves for 1")
    @Test
    void caves1() {
        System.out.println(dragon.caves(1));
        assertEquals("Gobbles you down in one bite!", dragon.caves(1),"Test of caves input of 1: failed");
    }

    @DisplayName("Test caves for 2")
    @Test
    void caves2() {
        assertEquals("Offers to share his gold with you!\n" +
                "You receive 1000 gold pieces!", dragon.caves(2),"Test of caves input of 2: failed");
    }

    @AfterEach
    void tearDown() {
    }

}