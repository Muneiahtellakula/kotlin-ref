package com.muneiah.myroomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepo
{
    StudentsDataBase studentsDataBase;
    LiveData<List<Student_entity>> listLiveData;

    public StudentRepo(Application application) {
        studentsDataBase=StudentsDataBase.getDataBase(application);
        listLiveData=studentsDataBase.studentsDAO().retrive();
    }

    public class MyasysncTak extends AsyncTask<Student_entity,Void,Void>{


        @Override
        protected Void doInBackground(Student_entity... student_entities) {
            studentsDataBase.studentsDAO().inset(student_entities[0]);
            return null;
        }
    }
    public class MyasysncTakupdate extends AsyncTask<Student_entity,Void,Void>{


        @Override
        protected Void doInBackground(Student_entity... student_entities) {
            studentsDataBase.studentsDAO().update(student_entities[0]);
            return null;
        }
    }
    public class MyasysncTakdelete extends AsyncTask<Student_entity,Void,Void>{


        @Override
        protected Void doInBackground(Student_entity... student_entities) {
            studentsDataBase.studentsDAO().delete(student_entities[0]);
            return null;
        }
    }
   public void insert(Student_entity entity){
        new MyasysncTak().execute(entity);
   }
    public void delete(Student_entity entity){
    MyasysncTakdelete myasysncTakdelete=new MyasysncTakdelete();
    myasysncTakdelete.execute(entity);
}

    public void update(Student_entity entity){
        MyasysncTakupdate myasysncTakupdate=new MyasysncTakupdate();
        myasysncTakupdate.execute(entity);
    }
    public LiveData<List<Student_entity>> liveData(){

        return listLiveData;
    }

}
