package com.muneiah.myroomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentsDAO {

    @Insert
    public void inset(Student_entity student_entity);

    @Query("SELECT * FROM students_table")
    public LiveData<List<Student_entity>> retrive(); //for normaldatabase public List<Student_entity> retrive();

    @Delete
    public void delete(Student_entity student_entity);

    @Update
    public void update(Student_entity student_entity);
}
