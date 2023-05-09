package com.example.todolist.database

import android.content.Context
import com.example.todolist.database.dto.note
import com.example.todolist.database.mapper.notemapper

class Repositorii constructor(private val database:MyDataBase) {

    companion object{
        private var INSTANSE: Repositorii? = null

        fun get(context:Context): Repositorii{
            if (INSTANSE == null){
                INSTANSE  = Repositorii(MyDataBase.get(context))
            }
            return INSTANSE as Repositorii
        }
    }
    fun saveNote(note: note) = database.inter().save(notemapper.toEnity(note))
    fun getById(id:Long)=database.inter().getByID(id)?.let { notemapper.toDTO(it) }

}