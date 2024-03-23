package com.example.prakt15_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class boxes (
    @PrimaryKey( autoGenerate = true)
    var id:Int?=null,

    @ColumnInfo("color_name")
    var color_name:String,

    @ColumnInfo("color_value")
    var color_value:String
)
