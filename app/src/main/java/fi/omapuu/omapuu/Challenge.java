package fi.omapuu.omapuu;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Challenge extends AppCompatActivity implements View.OnClickListener {
     private ImageView blue, quiz, map;
     private ConstraintLayout constraintLayout;
     ImageView omaPuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        blue = (ImageView) findViewById(R.id.blue);
        quiz = (ImageView) findViewById(R.id.quiz);
        map = (ImageView) findViewById(R.id.view_map);
        omaPuu = findViewById(R.id.omaPuu);
        constraintLayout = findViewById(R.id.popUP);
        // set on click listeners
        blue.setOnClickListener(this);
        quiz.setOnClickListener(this);
        map.setOnClickListener(this);
        Button noBtn = findViewById(R.id.nobtn);
        noBtn.setOnClickListener(this);

        if (FakeDatabase.getInstance().isChallengeDone()){
            blue.setImageResource(R.mipmap.ic_blue_prog_foreground);
        }

        if (FakeDatabase.getInstance().isQuizDone()){
            quiz.setImageResource(R.mipmap.ic_quiz_foreground);
        }

        if (FakeDatabase.getInstance().getLevel()==0){
            omaPuu.setImageResource(R.drawable.small);
        } else if (FakeDatabase.getInstance().getLevel()==1) {
            omaPuu.setImageResource(R.drawable.med);
        } else {
            omaPuu.setImageResource(R.drawable.large);
        }

        Button yesBtn = findViewById(R.id.button3);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NavMap.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        constraintLayout.setVisibility(View.INVISIBLE);


        if (FakeDatabase.getInstance().isChallengeDone()){
            blue.setImageResource(R.mipmap.ic_blue_prog_foreground);
        }

        if (FakeDatabase.getInstance().isQuizDone()){
            quiz.setImageResource(R.mipmap.ic_quiz_foreground);
        }

        if (FakeDatabase.getInstance().getLevel()==0){
            omaPuu.setImageResource(R.drawable.small);
        } else if (FakeDatabase.getInstance().getLevel()==1) {
            omaPuu.setImageResource(R.drawable.med);
        } else {
            omaPuu.setImageResource(R.drawable.large);
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
                Intent in = new Intent(v.getContext(), Quiz.class);
                startActivity(in);
                break;

            case R.id.button3:
                constraintLayout.setVisibility(View.INVISIBLE);
                //change text to new dialog box
                Intent in2 = new Intent(v.getContext(), Loading.class);
                startActivity(in2);
                break;

            case R.id.nobtn:
                constraintLayout.setVisibility(View.INVISIBLE);
                Log.d("OmaPuu","btn 4 pressed");
                break;

            case R.id.view_map:
                constraintLayout.setVisibility(View.INVISIBLE);
                Intent in3 = new Intent(v.getContext(), NavMap.class);
                startActivity(in3);
                break;
        }
    }

}
