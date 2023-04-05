package unipi.projects.unipiaudiostories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StoryActivity extends AppCompatActivity {

    TextView chooseLanguageTextView;
    Button chooseEnglishButton, chooseGreekButton, chooseJapaneseButton;

    // declaring Shared Preferences
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_KEY = "languagePreference";
    private static final String STRING_KEY = "chosenLanguage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // getting shared preferences and editor
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);

        // relating buttons and views to resources
        chooseLanguageTextView = findViewById(R.id.chooseLanguageTextView);

        chooseEnglishButton = findViewById(R.id.chooseEnglishLanguageButton);
        chooseGreekButton = findViewById(R.id.chooseGreekLanguageButton);
        chooseJapaneseButton = findViewById(R.id.chooseJapaneseLanguageButton);

        // getting preference value
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String userChosenLanguage = sharedPreferences.getString(STRING_KEY, "eng");

        switch(userChosenLanguage) {
            case "eng":
                chooseLanguageTextView.setText(R.string.choose_language_textview_eng);
                chooseEnglishButton.setText(R.string.choose_english_language_button_eng);
                chooseGreekButton.setText(R.string.choose_greek_language_button_eng);
                chooseJapaneseButton.setText(R.string.choose_japanese_language_button_eng);
                break;
            case "jp":
                chooseLanguageTextView.setText(R.string.choose_language_textview_jp);
                chooseEnglishButton.setText(R.string.choose_english_language_button_jp);
                chooseGreekButton.setText(R.string.choose_greek_language_button_jp);
                chooseJapaneseButton.setText(R.string.choose_japanese_language_button_jp);
                break;
            default:
                chooseLanguageTextView.setText(R.string.choose_language_textview_gr);
                chooseEnglishButton.setText(R.string.choose_english_language_button_gr);
                chooseGreekButton.setText(R.string.choose_greek_language_button_gr);
                chooseJapaneseButton.setText(R.string.choose_japanese_language_button_gr);
        }

    }

    public void chooseEnglishLanguage(View view) {
        saveStringToSharedPreferences("eng");
        Toast.makeText(getApplicationContext(), "Language set to english! \n" +
                "Please restart the app :) ", Toast.LENGTH_LONG).show();
    }

    public void chooseGreekLanguage(View view) {
        saveStringToSharedPreferences("gr");
        Toast.makeText(getApplicationContext(), "Language set to greek! \n" +
                "Please restart the app :) ", Toast.LENGTH_LONG).show();
    }

    public void chooseJapaneseLanguage(View view) {
        saveStringToSharedPreferences("jp");
        Toast.makeText(getApplicationContext(), "Language set to japanese! \n" +
                "Please restart the app :) ", Toast.LENGTH_LONG).show();
    }

    // method to handle saving of language to shared preferences
    private void saveStringToSharedPreferences(String myString) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STRING_KEY, myString);
        editor.apply();
    }

}