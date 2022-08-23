package com.josanna.projectone.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.josanna.projectone.entities.Entry
import com.josanna.projectone.entities.Horse


data class HorseWithEntries(
    @Embedded val horse: Horse,
    @Relation(
        parentColumn = "horseId",
        entityColumn = "horseId"
    )
    val entries: List<Entry>
)