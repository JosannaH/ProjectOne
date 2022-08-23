package com.josanna.projectone.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.josanna.projectone.entities.Entry
import com.josanna.projectone.entities.User

data class UserWithEntries(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val entries: List<Entry>
)