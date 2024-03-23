package com.example.prakt15_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
        fun insertUser(item:accounts)
    @Query("SELECT * FROM users")
        fun getAllUser():Flow<List<accounts>>

    @Query("SELECT id FROM users where email = :email1")
        fun getIdUser(email1: String): Int

    @Insert
        fun insertColor(item:boxes)
    @Query("SELECT * FROM colors")
        fun getAllColor():Flow<List<boxes>>

    @Query("SELECT id, password FROM users where email = :email")
        fun findByEmail(email: String): accountSigninTuple?
    @Update(entity = accounts::class)
        fun updateUsername(newName:accountUpdateUsernameTuple)
    @Query("select * from users where id=:userId")
        fun getById(userId:Int):Flow<accounts?>
}