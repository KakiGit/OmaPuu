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
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        if(message != null){
            ImageView rasp_icon = (ImageView) findViewById(R.id.rasp);
            rasp_icon.setImageResource(R.mipmap.ic_raspberry_foreground);
        } else {
            Log.d("OmaPuu", "couldn't find resource");
        }
    }
}
