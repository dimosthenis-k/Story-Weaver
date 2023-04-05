package unipi.projects.unipiaudiostories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StatsActivity extends AppCompatActivity {

    // declaring textviews
    TextView statsTitleTextview, firstStory, secondStory, thirdStory, fourthStory, fifthStory;
    TextView firstStoryCounter, secondStoryCounter, thirdStoryCounter, fourthStoryCounter, fifthStoryCounter;
    // handling preferences
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_KEY = "languagePreference";
    private static final String STRING_KEY = "chosenLanguage";
    private static final String COUNTER_KEY_1 = "firstCounter";
    private static final String COUNTER_KEY_2 = "secondCounter";
    private static final String COUNTER_KEY_3 = "thirdCounter";
    private static final String COUNTER_KEY_4 = "fourthCounter";
    private static final String COUNTER_KEY_5 = "fifthCounter";

    private int counterOne, counterTwo, counterThree, counterFour, counterFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        // relating views

        statsTitleTextview = findViewById(R.id.statsTitleTextview);
        firstStory = findViewById(R.id.firstStory);
        secondStory = findViewById(R.id.secondStory);
        thirdStory = findViewById(R.id.thirdStory);
        fourthStory = findViewById(R.id.fourthStory);
        fifthStory = findViewById(R.id.fifthStory);
        firstStoryCounter = findViewById(R.id.firstStoryCounterView);
        secondStoryCounter = findViewById(R.id.secondStoryCounterView);
        thirdStoryCounter = findViewById(R.id.thirdStoryCounterView);
        fourthStoryCounter = findViewById(R.id.fourthStoryCouterView);
        fifthStoryCounter = findViewById(R.id.fifthStoryCounterView);

        // getting preference value
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String userChosenLanguage = sharedPreferences.getString(STRING_KEY, "eng");

        // getting counters from shared preferences and setting them to textviews
        counterOne = sharedPreferences.getInt(COUNTER_KEY_1, 0);
        firstStoryCounter.setText(String.valueOf(counterOne));
        counterTwo = sharedPreferences.getInt(COUNTER_KEY_2, 0);
        secondStoryCounter.setText(String.valueOf(counterTwo));
        counterThree = sharedPreferences.getInt(COUNTER_KEY_3, 0);
        thirdStoryCounter.setText(String.valueOf(counterThree));
        counterFour = sharedPreferences.getInt(COUNTER_KEY_4, 0);
        fourthStoryCounter.setText(String.valueOf(counterFour));
        counterFive = sharedPreferences.getInt(COUNTER_KEY_5, 0);
        fifthStoryCounter.setText(String.valueOf(counterFive));


        switch (userChosenLanguage) {
            case "eng":
                statsTitleTextview.setText(R.string.stats_title_eng);
                firstStory.setText(R.string.stats_1st_eng);
                secondStory.setText(R.string.stats_2nd_eng);
                thirdStory.setText(R.string.stats_3rd_eng);
                fourthStory.setText(R.string.stats_4th_eng);
                fifthStory.setText(R.string.stats_5th_eng);
                break;
            case "jp":
                statsTitleTextview.setText(R.string.stats_title_jp);
                firstStory.setText(R.string.stats_1st_jp);
                secondStory.setText(R.string.stats_2nd_jp);
                thirdStory.setText(R.string.stats_3rd_jp);
                fourthStory.setText(R.string.stats_4th_jp);
                fifthStory.setText(R.string.stats_5th_jp);
                break;
            default:
                statsTitleTextview.setText(R.string.stats_title_gr);
                firstStory.setText(R.string.stats_1st_gr);
                secondStory.setText(R.string.stats_2nd_gr);
                thirdStory.setText(R.string.stats_3rd_gr);
                fourthStory.setText(R.string.stats_4th_gr);
                fifthStory.setText(R.string.stats_5th_gr);
        }


    }
}