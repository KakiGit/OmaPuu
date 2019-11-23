package fi.omapuu.omapuu;

public class FakeDatabase {
    boolean challengeDone;
    boolean quizDone;
    private static final FakeDatabase ourInstance = new FakeDatabase();

    public static FakeDatabase getInstance() {
        return ourInstance;
    }

    private FakeDatabase() {
    }

    public void setChallengeDone() {
        this.challengeDone = true;
    }

    public boolean isChallengeDone() {
        return challengeDone;
    }

    public void resetChallenge() {
        this.challengeDone = false;
    }

    public void resetQuiz() {
        this.quizDone = false;
    }

    public void setQuizDone() {
        this.quizDone = true;
    }

    public boolean isQuizDone() {
        return quizDone;
    }
}
