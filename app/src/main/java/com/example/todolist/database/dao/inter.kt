package com.example.todolist.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

import com.example.todolist.database.db
import kotlinx.coroutines.selects.select

@Dao
interface inter {
    @Insert(onConflict = REPLACE)
    fun save(db: db)
    @Query( "SELECT*FROM notes WHERE `id`=:id ")
    fun getByID(id:Long): db?
}