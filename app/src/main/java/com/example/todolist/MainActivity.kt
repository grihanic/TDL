package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.todolist.database.mapper.ViewModelUser

class MainActivity : AppCompatActivity() {
    private lateinit var  viewModel:ViewModelUser
    private lateinit var recyclerView:RecyclerView
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//работа перехода кнопки с одного xml файла на другой xml файл
        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        imageButton9.setOnClickListener {
            val Intent = Intent(this,MainActivity2::class.java)
            startActivity(Intent)
        }
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        viewModel= ViewModelProvider(this).get(ViewModelUser::class.java)

        val adapterUser= AdapterUser()
        var rv= findViewById<RecyclerView>(R.id.recyclerView)
        rv.adapter =adapterUser

        viewModel.browse().observe(this, Observer{
            adapterUser.setUserList(it)
        })

    }
    private fun addDataToList(){


    }


}