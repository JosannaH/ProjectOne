package com.josanna.projectone.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entry(
        @PrimaryKey
        val entryId: Int,
        val date: String,
        val time: String,
        val note: String, //or record?
        val user: String,
        val horseId: Int,
        val userId: Int
)
