package com.example.todolist.database.mapper

import MyDataBase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory

import com.example.todolist.database.Repositorii
import com.example.todolist.database.db
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelUser (app: Application): AndroidViewModel(app){
    private val dataBase : MyDataBase
    private val repositorii : Repositorii
    init {
         dataBase = MyDataBase.get (app)
        repositorii = Repositorii(dataBase.inter())
    }
  fun add ( user: db ){
    viewModelScope.launch(Dispatchers.IO) {
     repositorii.addUser(user)
    }
  }
    fun browse (): LiveData<List<db>>{
        return repositorii.browseUser
    }
}