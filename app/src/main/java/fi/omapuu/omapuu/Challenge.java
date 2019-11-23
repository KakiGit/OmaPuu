package fi.omapuu.omapuu;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        rasp = (ImageView) findViewById(R.id.rasp);
        quiz = (ImageView) findViewById(R.id.quiz);
        // set on click listeners
        rasp.setOnClickListener(this);
        quiz.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // perform action
        switch(v.getId()) {
            case R.id.rasp:
                rasp.setImageResource(R.mipmap.ic_raspberry_foreground);
                Intent in = new Intent(v.getContext(), NavMap.class);
                in.putExtra("message", "Raspberry selected, change button");
                startActivity(in);
                break;

            case R.id.quiz:
                quiz.setImageResource(R.mipmap.ic_quiz_foreground);
                Intent in2 = new Intent(v.getContext(), NavMap.class);
                in2.putExtra("message", "Quiz selected, change button");
                startActivity(in2);
                break;
        }
    }
}
