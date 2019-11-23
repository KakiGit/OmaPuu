package fi.omapuu.omapuu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class KnowledgeActivity extends AppCompatActivity {
    ImageView knowledge;
    int clickCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knowledge_view);
        knowledge = findViewById(R.id.knowledgePage);
        knowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount%3 == 0) {
                    knowledge.setImageResource(R.drawable.biodiversity);
                } else if (clickCount%3 == 1) {
                    knowledge.setImageResource(R.drawable.forest);
                } else if (clickCount%3 == 2) {
                    knowledge.setImageResource(R.drawable.sus);
                }
            }
        });
    }
}
