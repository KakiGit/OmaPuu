package fi.omapuu.omapuu;

public class FakeDatabase {
    boolean challengeDone;
    boolean quizDone;
    int level = 0;
    private static final FakeDatabase ourInstance = new FakeDatabase();

    public static FakeDatabase getInstance() {
        return ourInstance;
    }

    private FakeDatabase() {
    }

    public void setChallengeDone() {
        level++;
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
        level++;
        this.quizDone = true;
    }

    public int getLevel() {
        return level;
    }

    public boolean isQuizDone() {
        return quizDone;
    }
}
