package com.example.todolist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

import com.example.todolist.database.db
import kotlinx.coroutines.selects.select

@Dao
interface inter {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(user:db)
    @Query( "Select id, title, text From notes ORDER BY id DESC ")
    fun browse (): LiveData<List<db>>
}