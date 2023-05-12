package com.example.todolist.database

import androidx.lifecycle.LiveData
import com.example.todolist.database.dao.inter

class Repositorii(private val inter: inter) {
    val browseUser : LiveData<List<db>> =inter.browse()

    suspend fun addUser (user:db){
        inter.add(user)
    }


}