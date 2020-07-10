package com.muneiah.myroomdb;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/*For Given table name
* and Coloums info
* and gettters and setter*/
@Entity(tableName = "students_table")
public class Student_entity {

    @ColumnInfo(name = "studentName")
    private String name;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "rollnumber")
    private String number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
