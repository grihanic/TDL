package com.example.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.database.dao.inter
import kotlin.time.measureTime

@Database(entities = [db::class], version = 1)
abstract class MyDataBase:RoomDatabase() {
    companion object{
        private var  INSTANSE: MyDataBase? = null
        fun get(context:Context): MyDataBase{
            if (INSTANSE == null){
                INSTANSE = Room.databaseBuilder(context, MyDataBase::class.java,"database").build()
            }
            return  INSTANSE as MyDataBase
        }


    }
    abstract  fun inter():inter

}

