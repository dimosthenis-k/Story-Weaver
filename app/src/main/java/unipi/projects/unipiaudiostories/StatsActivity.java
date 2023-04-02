package unipi.projects.unipiaudiostories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {
    TextView sampleTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        sampleTextview = findViewById(R.id.sampleText);

    }
}