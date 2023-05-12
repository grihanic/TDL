package com.example.todolist.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class db (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val text: String
        )