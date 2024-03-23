package com.example.prakt15_database

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users", indices = [Index("email", unique=true)])
data class accounts (
    @PrimaryKey( autoGenerate = true)
    var id:Int?=null,

    @ColumnInfo("email", collate = ColumnInfo.NOCASE)
    var email:String,

    @ColumnInfo("username")
    var username:String,

    @ColumnInfo("password")
    var password:String,

    @ColumnInfo("created_at")
    var created_at:Int
)