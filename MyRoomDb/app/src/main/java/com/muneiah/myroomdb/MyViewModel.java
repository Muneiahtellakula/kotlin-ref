package com.muneiah.myroomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    StudentRepo studentRepo;
    LiveData<List<Student_entity>> listLiveData_model;


    public MyViewModel(@NonNull Application application) {
        super(application);
        studentRepo=new StudentRepo(application);
        listLiveData_model=studentRepo.liveData();
    }
    public void insert(Student_entity student_entity){
        studentRepo.insert(student_entity);
    }
    public void update(Student_entity student_entity){
        studentRepo.update(student_entity);
    }
    public void delete(Student_entity student_entity){
        studentRepo.delete(student_entity);
    }

    public LiveData<List<Student_entity>> livedata(){
        return listLiveData_model;
    }
}
