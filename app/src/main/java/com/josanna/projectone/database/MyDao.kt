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
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // suspend = executed in the background to not block main thread
    suspend fun insertCustomer(customer: Customer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHorse(horse: Horse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: Entry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    // get list of horses for customer
    @Transaction
    @Query("SELECT * FROM customer WHERE customerId = :customerId")
    suspend fun getCustomerWithHorses(customerId: Int): List<CustomerWithHorses>

    // get list of entries for horse
    @Transaction
    @Query("SELECT * FROM horse WHERE horseId = :horseId")
    suspend fun getHorseWithEntries(horseId: Int): List<HorseWithEntries>

    // get list of entries for user
    @Transaction
    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUserWithEntries(userId: Int): List<UserWithEntries>

}