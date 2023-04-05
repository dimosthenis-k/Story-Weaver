package unipi.projects.unipiaudiostories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView informationTextView;

    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_KEY = "languagePreference";
    private static final String STRING_KEY = "chosenLanguage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String userChosenLanguage = sharedPreferences.getString(STRING_KEY, "eng");

        // relating button to view
        informationTextView = findViewById(R.id.informationTextView);

        // setting proper language according to shared preference
        switch (userChosenLanguage) {
            case "eng":
                informationTextView.setText(R.string.team_info_eng);
                break;
            case "jp":
                informationTextView.setText(R.string.team_info_jp);
                break;
            default:
                informationTextView.setText(R.string.team_info_gr);
        }
    }
}