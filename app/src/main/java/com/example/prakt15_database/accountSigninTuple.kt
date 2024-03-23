package com.example.prakt15_database

data class accountSigninTuple(
    val id:Int,
    val password:String
)
data class accountUpdateUsernameTuple(
    val username:String,
    val id:Int
)
