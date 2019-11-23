package fi.omapuu.omapuu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class NavMap extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        if(message != null){


        } else {
            Log.d("OmaPuu", "couldn't find resource");
        }
    }

    public void onClick(View v) {
        // perform action
        switch(v.getId()) {
            case R.id.button3:

                setContentView(R.layout.navigation_map);
                break;

            case R.id.button4:
                setContentView(R.layout.activity_quiz);
                break;
        }
    }
}
