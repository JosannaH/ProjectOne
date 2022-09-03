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
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    // get list of entries for user
    @Transaction
    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUserWithEntries(userId: Int): List<UserWithEntries>

}