package unipi.projects.unipiaudiostories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    TextView messageOutput, year;
    ImageView downloadedPicture;
    FirebaseDatabase database;
    DatabaseReference reference1, reference2, reference3, reference4, reference5;
    DatabaseReference year1, year2, year3, year4, year5;
    StorageReference storageReference;

    Button stopStoryButton, firstStoryButton, secondStoryButton, thirdStoryButton, fourthStoryButton, fifthStoryButton;

    TextToSpeech textToSpeech;


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
        setContentView(R.layout.activity_main2);

        // relating buttons and views
        stopStoryButton = findViewById(R.id.stopStoryButton);
        year = findViewById(R.id.textView2);
        firstStoryButton = findViewById(R.id.firstStoryButton);
        secondStoryButton = findViewById(R.id.secondStoryButton);
        thirdStoryButton = findViewById(R.id.thirdStoryButton);
        fourthStoryButton = findViewById(R.id.fourthStoryButton);
        fifthStoryButton = findViewById(R.id.fifthStoryButton);

        // getting preference value
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String userChosenLanguage = sharedPreferences.getString(STRING_KEY, "eng");

        // getting counters from shared preferences
        counterOne = sharedPreferences.getInt(COUNTER_KEY_1, 0);
        counterOne = sharedPreferences.getInt(COUNTER_KEY_2, 0);
        counterOne = sharedPreferences.getInt(COUNTER_KEY_3, 0);
        counterOne = sharedPreferences.getInt(COUNTER_KEY_4, 0);
        counterOne = sharedPreferences.getInt(COUNTER_KEY_5, 0);

        // setting button text language
        switch (userChosenLanguage) {
            case "eng" :
                firstStoryButton.setText(R.string.first_story_name_eng);
                secondStoryButton.setText(R.string.second_story_name_eng);
                thirdStoryButton.setText(R.string.third_story_name_eng);
                fourthStoryButton.setText(R.string.fourth_story_name_eng);
                fifthStoryButton.setText(R.string.fifth_story_name_eng);
                stopStoryButton.setText(R.string.stop_running_story_eng);
                break;
            case "jp" :
                firstStoryButton.setText(R.string.first_story_name_jp);
                secondStoryButton.setText(R.string.second_story_name_jp);
                thirdStoryButton.setText(R.string.third_story_name_jp);
                fourthStoryButton.setText(R.string.fourth_story_name_jp);
                fifthStoryButton.setText(R.string.fifth_story_name_jp);
                stopStoryButton.setText(R.string.stop_running_story_jp);
                break;
            default :
                firstStoryButton.setText(R.string.first_story_name_gr);
                secondStoryButton.setText(R.string.second_story_name_gr);
                thirdStoryButton.setText(R.string.third_story_name_gr);
                fourthStoryButton.setText(R.string.fourth_story_name_gr);
                fifthStoryButton.setText(R.string.fifth_story_name_gr);
                stopStoryButton.setText(R.string.stop_running_story_gr);
        }

        // establishing firebase connection and references
        database = FirebaseDatabase.getInstance();
        reference1 = database.getReference("message1");
        reference2 = database.getReference("message2");
        reference3 = database.getReference("message3");
        reference4 = database.getReference("message4");
        reference5 = database.getReference("message5");
        year1 = database.getReference("year1");
        year2 = database.getReference("year2");
        year3 = database.getReference("year3");
        year4 = database.getReference("year4");
        year5 = database.getReference("year5");

        downloadedPicture = findViewById(R.id.imageView);

        storageReference = FirebaseStorage.getInstance().getReference();


        // Initialize TextToSpeech object
        textToSpeech = new TextToSpeech(this, status -> {
            // Check initialization status
            if (status == TextToSpeech.SUCCESS) {
                // Set language and other parameters
                textToSpeech.setLanguage(Locale.US);
                textToSpeech.setSpeechRate(1.0f);
                textToSpeech.setPitch(1.0f);

            }
        });

    }

    public void stopStory(View view) {
        textToSpeech.stop();
    }

    public void story1(View view) {

        // incrementing appropriate counter on click
        counterOne++;

        // saving counter to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY_1, counterOne);
        editor.apply();

        year1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    year.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    year.setText(error.getMessage());
                }
            });

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //messageOutput.setText(snapshot.getValue().toString());
                textToSpeech.stop();
                textToSpeech.speak(snapshot.getValue().toString(),TextToSpeech.QUEUE_ADD,null,null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //messageOutput.setText(error.getMessage());
            }
        });



        StorageReference imageRef1 = storageReference.child("king.jpg");
        try {
            File localFile = File.createTempFile("tempImage", "jpg");
            imageRef1.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    downloadedPicture.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void story2(View view) {

        // incrementing counter
        counterTwo++;

        // saving counter to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY_2, counterTwo);
        editor.apply();

        year2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                year.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                year.setText(error.getMessage());
            }
        });

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // messageOutput.setText(snapshot.getValue().toString());
                textToSpeech.stop();
                textToSpeech.speak(snapshot.getValue().toString(),TextToSpeech.QUEUE_ADD,null,null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
               // messageOutput.setText(error.getMessage());
            }
        });

        StorageReference imageRef2 = storageReference.child("pot.jpg");
        try {
            File localFile = File.createTempFile("tempImage", "jpg");
            imageRef2.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    downloadedPicture.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void story3(View view) {

        // incrementing counter
        counterThree++;

        // saving counter to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY_3, counterThree);
        editor.apply();

        year3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                year.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                year.setText(error.getMessage());
            }
        });

        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // messageOutput.setText(snapshot.getValue().toString());
                textToSpeech.stop();
                textToSpeech.speak(snapshot.getValue().toString(),TextToSpeech.QUEUE_ADD,null,null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
               // messageOutput.setText(error.getMessage());
            }
        });

        StorageReference imageRef3 = storageReference.child("tosodoulis.jpg");
        try {
            File localFile = File.createTempFile("tempImage", "jpg");
            imageRef3.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    downloadedPicture.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void story4(View view) {

        // incrementing counter
        counterFour++;

        // saving counter to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY_4, counterFour);
        editor.apply();

        year4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                year.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                year.setText(error.getMessage());
            }
        });

        reference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
             //   messageOutput.setText(snapshot.getValue().toString());
                textToSpeech.stop();
                textToSpeech.speak(snapshot.getValue().toString(),TextToSpeech.QUEUE_ADD,null,null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
             //   messageOutput.setText(error.getMessage());
            }
        });

        StorageReference imageRef4 = storageReference.child("fox.jpg");
        try {
            File localFile = File.createTempFile("tempImage", "jpg");
            imageRef4.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    downloadedPicture.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void story5(View view) {

        // incrementing counter
        counterFive++;

        // saving counter to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY_5, counterFive);
        editor.apply();

        year5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                year.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                year.setText(error.getMessage());
            }
        });

        reference5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
             //   messageOutput.setText(snapshot.getValue().toString());
                textToSpeech.stop();
                textToSpeech.speak(snapshot.getValue().toString(),TextToSpeech.QUEUE_ADD,null,null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
               // messageOutput.setText(error.getMessage());
            }
        });

        StorageReference imageRef5 = storageReference.child("pigs.jpg");
        try {
            File localFile = File.createTempFile("tempImage", "jpg");
            imageRef5.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    downloadedPicture.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}