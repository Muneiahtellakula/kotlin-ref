package com.muneiah.myroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
static StudentsDataBase studentsDataBase;
EditText name,num;
Student_entity student_entity;
RecyclerView rec;
MyAdapter adapter;
List<Student_entity> student_entityList;
static MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editText);
        num=findViewById(R.id.editText2);
        rec=findViewById(R.id.recyclerView);
       // studentsDataBase= Room.databaseBuilder(this,StudentsDataBase.class,"StudentsDb").allowMainThreadQueries().build();
        myViewModel=ViewModelProviders.of(this).get(MyViewModel.class);
        /*mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);*/
        //myViewModel=new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.livedata().observe(this, new Observer<List<Student_entity>>() {
            @Override
            public void onChanged(List<Student_entity> student_entities) {
                adapter =new MyAdapter(MainActivity.this,student_entities);
                Toast.makeText(MainActivity.this, "Total :"+student_entities.size(), Toast.LENGTH_SHORT).show();
                rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rec.setAdapter(adapter);
            }
        });
    }

    public void saveData(View view) {
        String n=name.getText().toString();
        String nn=num.getText().toString();
        student_entity=new Student_entity();
        student_entity.setName(n);
        student_entity.setNumber(nn);
        //studentsDataBase.studentsDAO().inset(student_entity);
        myViewModel.insert(student_entity);

    }

    public void retriveData(View view) {
      // student_entityList= studentsDataBase.studentsDAO().retrive(); for normal db
        /*adapter =new MyAdapter(this,student_entityList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);*/
        /*myViewModel.livedata().observe(this, new Observer<List<Student_entity>>() {
            @Override
            public void onChanged(List<Student_entity> student_entities) {
                adapter =new MyAdapter(MainActivity.this,student_entities);
                rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rec.setAdapter(adapter);
            }
        });*/
    }
}
