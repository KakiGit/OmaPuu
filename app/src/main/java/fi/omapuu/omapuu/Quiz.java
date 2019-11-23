package fi.omapuu.omapuu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Quiz extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button nxt;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){

                if (checkedId == R.id.radio3) {
                    //setContentView(R.layout.final1);
                    tv = findViewById(R.id.textView5);
                    tv.setVisibility(View.VISIBLE);
                }
                else{
                    //setContentView(R.layout.final2);
                    tv = findViewById(R.id.textView); //print wrong answer
                    tv.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}