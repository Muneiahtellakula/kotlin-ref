package com.muneiah.cricketscoreapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_board")
data class ScoreDetails_Entity(
    @PrimaryKey(autoGenerate = true)
    var inning_id: Int = 0,
    var run: Int = 0,
    var wickets: Int = 0,
    var over: Int = 0,
    var balls: Int = 0
)