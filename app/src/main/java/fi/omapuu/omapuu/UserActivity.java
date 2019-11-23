package fi.omapuu.omapuu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class UserActivity extends AppCompatActivity {
    ImageView userPage;
    int clickCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        userPage = findViewById(R.id.userPage);
        userPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount%2 == 0) {
                    userPage.setImageResource(R.drawable.user_badges);
                } else if (clickCount%2 == 1) {
                    userPage.setImageResource(R.drawable.nuuksia_tree);
                }
            }
        });
    }
}
