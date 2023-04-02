package unipi.projects.unipiaudiostories;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class MyTextToSpeech {

    private TextToSpeech textToSpeech;

    private TextToSpeech.OnInitListener initListener = new android.speech.tts.TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            textToSpeech.setLanguage(Locale.ENGLISH);
        }
    };

    public MyTextToSpeech(Context context) {
        textToSpeech = new TextToSpeech(context, initListener);
    }

    public void speak(String message) {
        textToSpeech.speak(message, TextToSpeech.QUEUE_ADD, null, null);
    }


}
