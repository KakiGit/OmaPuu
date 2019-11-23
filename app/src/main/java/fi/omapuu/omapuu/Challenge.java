package fi.omapuu.omapuu;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Challenge extends AppCompatActivity implements View.OnClickListener {
     private  ImageView blue;
     private ImageView quiz;
     private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        blue = (ImageView) findViewById(R.id.blue);
        quiz = (ImageView) findViewById(R.id.quiz);

        constraintLayout = findViewById(R.id.popUP);
        // set on click listeners
        blue.setOnClickListener(this);
        quiz.setOnClickListener(this);

        if (FakeDatabase.getInstance().isChallengeDone()){
            blue.setImageResource(R.mipmap.ic_blue_prog_foreground);
        }

        if (FakeDatabase.getInstance().isQuizDone()){
            quiz.setImageResource(R.mipmap.ic_quiz_foreground);
        }

    }

    @Override
    public void onClick(View v) {
        // perform action
        switch(v.getId()) {
            case R.id.blue:
                FakeDatabase.getInstance().setChallengeDone();
                constraintLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.quiz:
                FakeDatabase.getInstance().setQuizDone();
                constraintLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.button4:
                FakeDatabase.getInstance().resetChallenge();
                FakeDatabase.getInstance().resetQuiz(); // no selection
                constraintLayout.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
