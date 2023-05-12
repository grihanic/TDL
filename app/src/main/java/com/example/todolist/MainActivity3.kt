package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Insert
import com.example.myapplication.R
import com.example.todolist.database.db
import com.example.todolist.database.mapper.ViewModelUser
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi

class MainActivity3 : AppCompatActivity() {
    private lateinit var viewmodel: ViewModelUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        imageButton3.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
        viewmodel = ViewModelProvider(this).get(ViewModelUser::class.java)
        val inpuTtitle = findViewById<EditText>(R.id.create_title2)
        val inputText = findViewById<EditText>(R.id.create_title)

        findViewById<ImageButton>(R.id.imageButton3).setOnClickListener{
            val user = db (id=0, title =inpuTtitle.text.toString(), text =inputText.text.toString())
            viewmodel.add(user)
            inpuTtitle.setText("")
            inputText.setText("")
            Toast.makeText(this,"Data Saved", Toast.LENGTH_LONG).show()
            val intent= Intent(this,MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
            startActivity(intent)
        }
    }
}