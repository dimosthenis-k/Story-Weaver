package unipi.projects.unipiaudiostories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // copy to all classes I guess?
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_KEY = "languagePreference";
    private static final String STRING_KEY = "chosenLanguage";

    Button storyStartButton, storySettingsButton, userStatsButton, informationButton;
    TextView welcomeTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting preference value
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String userChosenLanguage = sharedPreferences.getString(STRING_KEY, "eng");

        // relating views with objects
        welcomeTextView = findViewById(R.id.welcomeMessage);

        // relating buttons with objects
        storyStartButton = findViewById(R.id.storyStartButton);
        storySettingsButton = findViewById(R.id.storySettingsButton);
        userStatsButton = findViewById(R.id.userStatsButton);
        informationButton = findViewById(R.id.informationButton);

        // setting proper language according to shared preference
        switch (userChosenLanguage) {
            case "eng" :
                welcomeTextView.setText(R.string.welcome_message_eng);
                storyStartButton.setText(R.string.story_button_eng);
                storySettingsButton.setText(R.string.settings_button_eng);
                userStatsButton.setText(R.string.stats_button_eng);
                informationButton.setText(R.string.info_button_eng);
                break;
            case "jp" :
                welcomeTextView.setText(R.string.welcome_message_jp);
                storyStartButton.setText(R.string.story_button_jp);
                storySettingsButton.setText(R.string.settings_button_jp);
                userStatsButton.setText(R.string.stats_button_jp);
                informationButton.setText(R.string.info_button_jp);
                break;
            default:
                welcomeTextView.setText(R.string.welcome_message_gr);
                storyStartButton.setText(R.string.story_button_gr);
                storySettingsButton.setText(R.string.settings_button_gr);
                userStatsButton.setText(R.string.stats_button_gr);
                informationButton.setText(R.string.info_button_gr);
        }


    }

    // MainActivity button events | creating new activities and passing information
    public void goToStory(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void goToSettings(View view){
        Intent intent = new Intent(this,StoryActivity.class);
        startActivity(intent);
    }

    public void goToStats(View view){
        Intent intent = new Intent(this,StatsActivity.class);
        startActivity(intent);
    }

    public void goToInfo(View view){
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
    }



}