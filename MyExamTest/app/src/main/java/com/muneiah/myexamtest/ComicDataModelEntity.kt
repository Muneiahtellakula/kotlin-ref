package com.muneiah.myexamtest

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "comic_details")
data class ComicDataModelEntity(
    @PrimaryKey(autoGenerate = true)
    var comic_id:Int=0,
    var comic_name:String="",
    var comic_dec:String=""
)
