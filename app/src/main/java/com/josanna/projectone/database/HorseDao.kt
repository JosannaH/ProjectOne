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

@Dao
interface HorseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertHorse(horse: Horse)

    @Transaction
    @Query("SELECT * FROM horse ORDER BY name ASC")
    //TODO: Do I need to return LiveData here?
    suspend fun getAllHorses(): List<Horse>

    @Delete
    suspend fun deleteHorse(horse: Horse)

    // get list of entries for horse
    @Transaction
    @Query("SELECT * FROM horse WHERE horseId = :horseId")
    suspend fun getHorseWithEntries(horseId: Int): List<HorseWithEntries>

}