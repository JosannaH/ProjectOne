package com.josanna.projectone.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.josanna.projectone.entities.Customer
import com.josanna.projectone.entities.Horse

data class CustomerWithHorses(

    @Embedded val customer: Customer,
    @Relation(
        // column in Customer
        parentColumn = "customerId",
        // column in Horse
        entityColumn = "customerId"
    )
    val horses: List<Horse>
)