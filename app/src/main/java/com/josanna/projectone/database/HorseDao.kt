package com.josanna.projectone.database

import androidx.room.*
import androidx.room.Dao
import com.josanna.projectone.entities.Customer
import com.josanna.projectone.entities.Entry
import com.josanna.projectone.entities.Horse
import com.josanna.projectone.entities.User
import com.josanna.projectone.entities.relations.CustomerWithHorses
import com.josanna.projectone.entities.relations.HorseWithEntries
import com.josanna.projectone.entities.relations.UserWithEntries

// Data Access Object
@Dao
interface HorseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHorse(horse: Horse)

    @Transaction
    @Query("SELECT * FROM horse ORDER BY name ASC")
    suspend fun getAllHorses(): List<Horse>

    // get list of entries for horse
    @Transaction
    @Query("SELECT * FROM horse WHERE horseId = :horseId")
    suspend fun getHorseWithEntries(horseId: Int): List<HorseWithEntries>

}