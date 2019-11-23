package fi.omapuu.omapuu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class PlantTree extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_tree);
        ImageView cameraBtn = findViewById(R.id.imageView5);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(),CameraActivity.class);
                startActivity(intent);
            }
        });

        Button plant = findViewById(R.id.button2);
        plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Challenge.class);
//                in.putExtra("message", "Raspberry selected, change button");
                startActivity(in);
            }

        });
    }



}
