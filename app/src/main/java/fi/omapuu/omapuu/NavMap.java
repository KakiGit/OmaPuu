package fi.omapuu.omapuu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class NavMap extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_map);
       // setContentView(R.layout.activity_challenge);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        if(message != null){
//            ImageView rasp_icon = (ImageView) findViewById(R.id.rasp);
//            ImageView ques_icon = (ImageView) findViewById(R.id.quiz);
//            rasp_icon.setImageResource(R.mipmap.ic_raspberry_foreground);
//            ques_icon.setImageResource(R.mipmap.ic_quiz_foreground);
        } else {
            Log.d("OmaPuu", "couldn't find resource");
        }
    }
}
