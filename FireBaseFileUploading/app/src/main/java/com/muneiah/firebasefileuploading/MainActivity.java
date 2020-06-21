package com.muneiah.firebasefileuploading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_ID = 112;
    EditText name, mobile;
    TextView show_tv;
    FirebaseDatabase database;
    FirebaseStorage storage;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.ed);
        mobile = findViewById(R.id.edt);
        show_tv = findViewById(R.id.tv);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        storage=FirebaseStorage.getInstance();


    }


    public void upload_btn(View view) {

    }

    public void download_btn(View view) {
    }
}
