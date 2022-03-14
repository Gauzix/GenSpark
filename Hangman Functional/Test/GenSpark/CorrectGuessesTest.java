package GenSpark;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectGuessesTest {

     CorrectGuesses correctGuesses = new CorrectGuesses("l");

    @Test
    void addGuess() {
    }

    @Test
    void correctLetter() {
        assertTrue(!correctGuesses.correctLetter("l"));
    }
}