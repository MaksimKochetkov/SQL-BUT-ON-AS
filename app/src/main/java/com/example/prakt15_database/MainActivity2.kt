package com.example.prakt15_database

import android.accounts.AuthenticatorException
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prakt15_database.databinding.ActivityMain2Binding
var c:Int=0
class MainActivity2 : AppCompatActivity() {
    lateinit var db: MainDB
    lateinit var bind: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bind.root)
        db = MainDB.createDB(this)
        bind.button2.setOnClickListener {

                val a = bind.editTextText.text.toString()
                val b = bind.editTextText2.text.toString()
            Thread {
                 c = login(a,b)

            }.start()

        }


        bind.polsovatel.text=""
        bind.button3.setOnClickListener{
            bind.polsovatel.text = c.toString()
//            fun login(mail:String, pass:Int):Int {
//                val answer = db.getDao().findByEmail(mail)?: throw AuthenticatorException()
//                if (answer.password!=pass) throw AuthenticatorException()
//                return answer.id
//
//                val text="id:${answer.id} \n"
//                bind.polsovatel.append(text)}


        }


    }
    fun login(mail:String, pass:String):Int {
        val answer = db.getDao().findByEmail(mail)?: throw AuthenticatorException()
        if (answer.password!=pass) throw AuthenticatorException()
        return answer.id
    }
}