package GenSpark;

import java.util.HashSet;
import java.util.Set;

public class CorrectGuesses {
    private String correctAnswer;
    private Set<String> correctGuesses = new HashSet<String>();

    public CorrectGuesses(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addGuess(String guess){
        if (correctAnswer.contains(guess)) {
            correctGuesses.add(guess);
        }
    }

    public boolean correctLetter(String letter) {
        return correctGuesses.contains(letter);
    }
}
