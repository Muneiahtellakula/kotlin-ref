package com.muneiah.cricketscoreapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ScoreDetails_Entity::class],version = 1,exportSchema = false)
abstract class ScoreDataBase : RoomDatabase(){

    abstract val scoreDao : ScoreDao

    companion object {

        @Volatile
        var INSTANCE : ScoreDataBase? = null

        fun getInstance(context: Context) : ScoreDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(context,ScoreDataBase::class.java,"scoredb").fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}