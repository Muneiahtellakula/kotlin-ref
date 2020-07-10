package com.muneiah.myroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.muneiah.myroomdb.MainActivity.studentsDataBase;

public class UpdateActivity extends AppCompatActivity {
    EditText uet1, uet2;
    Student_entity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        uet1 = findViewById(R.id.et1);
        uet2 = findViewById(R.id.et2);
        Intent i=getIntent();
       String r1= i.getStringExtra("name");
        String r2=i.getStringExtra("roll");
        uet1.setText(r1);
        uet2.setText(r2);
        uet2.setKeyListener(null);

    }

    public void updateData(View view) {
        entity= new Student_entity();
        String nn = uet1.getText().toString();
        String nrr = uet2.getText().toString();
        entity.setName(nn);
        entity.setNumber(nrr);
       // studentsDataBase.studentsDAO().update(entity);
        MainActivity.myViewModel.update(entity);
        finish();
    }
}
