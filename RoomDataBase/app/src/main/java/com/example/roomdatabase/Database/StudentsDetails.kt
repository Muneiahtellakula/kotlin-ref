package com.example.roomdatabase.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_details")
data class StudentsDetails(
    @PrimaryKey(autoGenerate = true)
    var student_id:Int=0,
    var student_name:String="",
    var student_age:Int=0
)