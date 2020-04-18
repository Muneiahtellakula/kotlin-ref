package com.example.roomdatabase.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentsDetails::class],version = 1,exportSchema = false)//data base strures file save if need true
abstract class StudentDataBase :RoomDatabase() {
    abstract val stdentDao: StudentDao

    companion object{

        @Volatile//doesnot store
        var INSTANCE:StudentDataBase? =null//cached var instance cann't store
        fun getInstance(context:Context):StudentDataBase{

            synchronized(this){
                var instance=INSTANCE
                if (instance==null){
                    instance= Room.databaseBuilder(context,StudentDataBase::class.java,"studentDb").fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance

                }
                return instance
            }

        }


    }
}
