package com.josanna.projectone.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Horse(
        @PrimaryKey(autoGenerate = true)
        val horseId: Int,
        val name: String,
        val type: String,
        val gender: String,
        val birthYear: String,
        val identification: String,
        val notes: String,
        val customerId: Int
)
