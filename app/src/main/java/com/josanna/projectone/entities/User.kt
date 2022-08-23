package com.josanna.projectone.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey
        val userId: Int,
        val firstName: String,
        val lastName: String,
        val title: String,
        val password: String,
        val phone: String,
        val email: String
)
