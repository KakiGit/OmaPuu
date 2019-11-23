package fi.omapuu.omapuu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;


public class Quiz extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button nxt;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if (checkedId == R.id.radio1) {
                    setContentView(R.layout.final2);
                }
                else if (checkedId == R.id.radio2){
                    setContentView(R.layout.final2);
                }
                else if (checkedId == R.id.radio3) {
                    setContentView(R.layout.final1);
                }
                else{
                    setContentView(R.layout.final2);
                }
            }
        });
    }
}