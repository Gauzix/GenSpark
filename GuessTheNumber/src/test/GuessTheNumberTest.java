import genSpark.GuessTheNumber;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {

    GuessTheNumber guessTheNumber;

    @BeforeEach
    void setUp() {
        guessTheNumber = new GuessTheNumber();
    }

    @DisplayName("Test playAgain for y")
    @Test
    void playAgain1() {
        System.out.println(guessTheNumber.playAgain("y"));
        assertEquals("Same rules, let's go again!", guessTheNumber.playAgain("y"),"playAgain test for 'y' failed.");
    }

    @DisplayName("Test playAgain for n")
    @Test
    void playAgain2() {
        System.out.println(guessTheNumber.playAgain("n"));
        assertEquals("Scared you'd lose?", guessTheNumber.playAgain("n"),"playAgain test for 'n' failed.");
    }

    @AfterEach
    void tearDown() {
    }

}