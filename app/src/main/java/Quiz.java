import java.util.ArrayList;
import java.util.List;

public class Quiz
{
    private int score;
    private int current;
    private List<Question> questions;

    public Quiz(List<Question> questionsList)
    {
        score = 0;
        current = 0;
        questions = questionsList;

    }

    public void setQuestions(List<Question> questionsList)
    {
        questions= questionsList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void nextQuestion()
    {
        current+=1;
    }

    public boolean isThereAnotherQ()
    {
        if(current < 10)

    }
}
