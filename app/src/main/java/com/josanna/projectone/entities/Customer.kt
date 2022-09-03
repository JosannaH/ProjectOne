package com.josanna.projectone.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(

        @PrimaryKey(autoGenerate = true)
        val customerId: Int,
        val firstName: String,
        val lastName: String,
        val street: String,
        val postCode: String,
        val city: String,
        val phone: String,
        val email: String,
        val notes: String
)
