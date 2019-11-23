package fi.omapuu.omapuu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Quiz extends AppCompatActivity {
    ImageView quiz;
    int clickCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quiz = findViewById(R.id.imageView9);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount == 2) {
                    quiz.setImageResource(R.drawable.quiz1_a);
                } else if (clickCount == 3) {
                    quiz.setImageResource(R.drawable.quiz2);
                } else if (clickCount == 5) {
                    quiz.setImageResource(R.drawable.quiz2_a);
                } else if (clickCount == 6) {
                    quiz.setImageResource(R.drawable.quiz3);
                } else if (clickCount == 8) {
                    quiz.setImageResource(R.drawable.quiz3_a);
                } else if (clickCount == 9) {
                    FakeDatabase.getInstance().setQuizDone();
                    quiz.setImageResource(R.drawable.quizdone);
                }
            }
        });

    }
}