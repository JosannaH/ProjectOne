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
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // suspend = executed in the background to not block main thread
    suspend fun insertCustomer(customer: Customer)

    // get list of horses for customer
    @Transaction
    @Query("SELECT * FROM customer WHERE customerId = :customerId")
    suspend fun getCustomerWithHorses(customerId: Int): List<CustomerWithHorses>


}