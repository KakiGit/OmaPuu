package fi.omapuu.omapuu;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Challenge extends AppCompatActivity implements View.OnClickListener {
     private  ImageView rasp;
     private ImageView quiz;
     private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        rasp = (ImageView) findViewById(R.id.rasp);
        quiz = (ImageView) findViewById(R.id.quiz);

        constraintLayout = findViewById(R.id.popUP);
        // set on click listeners
        rasp.setOnClickListener(this);
        quiz.setOnClickListener(this);

        if (FakeDatabase.getInstance().isChallengeDone()){
            rasp.setImageResource(R.mipmap.ic_raspberry_foreground);
        }

        if (FakeDatabase.getInstance().isQuizDone()){
            quiz.setImageResource(R.mipmap.ic_quiz_foreground);
        }

    }

    @Override
    public void onClick(View v) {
        // perform action
        switch(v.getId()) {
            case R.id.rasp:
                FakeDatabase.getInstance().setChallengeDone();
                constraintLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.quiz:
                FakeDatabase.getInstance().setQuizDone();
                constraintLayout.setVisibility(View.VISIBLE);
                break;
        }
    }
}
