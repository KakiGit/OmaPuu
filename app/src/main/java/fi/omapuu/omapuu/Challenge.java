package fi.omapuu.omapuu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Challenge extends AppCompatActivity {
    private ImageView rasp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        rasp = (ImageView) findViewById(R.id.rasp);
        rasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), NavMap.class);
                in.putExtra("message", "Raspberry selected, change button");
                startActivity(in);

            }
        });

    }

}
