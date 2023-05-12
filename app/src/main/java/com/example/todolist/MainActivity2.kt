package com.example.todolist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.myapplication.R
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity2 : AppCompatActivity() {

    @OptIn(InternalCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //работа перехода кнопки с одного xml файла на другой xml файл
        val imageButton8 = findViewById<ImageButton>(R.id.imageButton8)
        val imageButton6 = findViewById<ImageButton>(R.id.imageButton6)
        imageButton8.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
            }
            imageButton6.setOnClickListener {
                val Intent = Intent(this, MainActivity3::class.java)
                startActivity(Intent)
            }



    }

}
