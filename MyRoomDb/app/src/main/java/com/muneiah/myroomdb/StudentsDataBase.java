package com.muneiah.myroomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student_entity.class, version = 3, exportSchema = false)
public abstract class StudentsDataBase extends RoomDatabase {
    private static StudentsDataBase INSTANCE;

    public abstract StudentsDAO studentsDAO();

//every time sync
    public static synchronized StudentsDataBase getDataBase(Context context) {
    if (INSTANCE==null){
        INSTANCE=Room.databaseBuilder(context,StudentsDataBase.class,"StudentsDb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()//when change version
                .build();
    }

        return INSTANCE;

    }

}
