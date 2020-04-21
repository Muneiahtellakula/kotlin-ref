package com.muneiah.myexamtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ComicDataModelEntity::class],version = 1,exportSchema = false)
abstract class ComicDatabase :RoomDatabase() {
    abstract val comicDao : Comic_Dao

    companion object {

        @Volatile
        var INSTANCE : ComicDatabase? = null

        fun getInstance(context: Context) : ComicDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(context,ComicDatabase::class.java,"comicdab").fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }


}
