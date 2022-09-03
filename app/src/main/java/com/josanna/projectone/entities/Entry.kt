package com.josanna.projectone.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entry(
        @PrimaryKey(autoGenerate = true)
        val entryId: Int,
        val date: String,
        val time: String,
        val note: String,
        val user: String,
        val horseId: Int,
        val userId: Int
)
