package com.example.prakt15_database

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import com.example.prakt15_database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val bd=MainDB.createDB(this)

        bd.getDao().getAllUser().asLiveData().observe(this){
            bind.textView.text=""
            it.forEach{
                val text="id:${it.id}, email:${it.email}, name:${it.username}, pass:${it.password}\n"
                bind.textView.append(text)
            }
        }

        bind.button.setOnClickListener{
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            val record=accounts(
                null,
                bind.email.text.toString(),
                bind.username.text.toString(),
                bind.password.text.toString(),
                bind.create.text.toString().toInt())
        Thread {
            bd.getDao().insertUser(record)
        }.start()
    }
    }
}