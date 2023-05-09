package com.example.todolist.database.mapper

import com.example.todolist.database.db
import com.example.todolist.database.dto.note

object notemapper:Mapper<db,note>   {
    override fun toDTO(from: db): note {
        return note(
            id=from.id,
            title=from.title,
            text =from.text
        )
    }

    override fun toEnity(from: note): db {
        return db(
            id=from.id,
            title=from.title,
            text =from.text
        )
    }
}

