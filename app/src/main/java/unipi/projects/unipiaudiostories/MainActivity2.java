package unipi.projects.unipiaudiostories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    TextView messageOutput;
    ImageView downloadedPicture;
    FirebaseDatabase database;
    DatabaseReference reference1, reference2, reference3, reference4, reference5;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        messageOutput = findViewById(R.id.textView);

        // establishing firebase connection and references
        database = FirebaseDatabase.getInstance();
        reference1 = database.getReference("message1");
        reference2 = database.getReference("message2");
        reference3 = database.getReference("message3");
        reference4 = database.getReference("message4");
        reference5 = database.getReference("message5");
        downloadedPicture = findViewById(R.id.imageView);
        storageReference = FirebaseStorage.getInstance().getReference();

        // added vertical scrollbar to story text
        messageOutput.setMovementMethod(new ScrollingMovementMethod());

    }

    public void story1(View view) {
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageOutput.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                messageOutput.setText(error.getMessage());
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
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageOutput.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                messageOutput.setText(error.getMessage());
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
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageOutput.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                messageOutput.setText(error.getMessage());
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
        reference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageOutput.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                messageOutput.setText(error.getMessage());
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
        reference5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageOutput.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                messageOutput.setText(error.getMessage());
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