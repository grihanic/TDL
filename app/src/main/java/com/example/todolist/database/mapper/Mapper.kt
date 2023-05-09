package com.example.todolist.database.mapper

interface Mapper<T,R> {
    fun toDTO(from:T):R
    fun toEnity(from:R):T
}