package unipi.projects.unipiaudiostories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button storyStartButton, storySettingsButton, userStatsButton, informationButton;
    TextView welcomeTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // relating views with objects
        welcomeTextView = findViewById(R.id.welcomeMessage);

        // relating buttons with objects
        storyStartButton = findViewById(R.id.storyStartButton);
        storySettingsButton = findViewById(R.id.storySettingsButton);
        userStatsButton = findViewById(R.id.userStatsButton);
        informationButton = findViewById(R.id.informationButton);

        // setting button text
        //TODO fix language selection and load proper resource onCreate
        welcomeTextView.setText(R.string.welcome_message_gr);

        storyStartButton.setText(R.string.story_button_eng);
        storySettingsButton.setText(R.string.settings_button_eng);
        userStatsButton.setText(R.string.stats_button_eng);
        informationButton.setText(R.string.info_button_eng);

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