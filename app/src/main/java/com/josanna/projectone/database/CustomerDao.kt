package com.josanna.projectone.database

import androidx.room.*
import androidx.room.Dao
import com.josanna.projectone.entities.Customer
import com.josanna.projectone.entities.relations.CustomerWithHorses

// Data Access Object
@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // suspend = executed in the background to not block main thread
    suspend fun upsertCustomer(customer: Customer)

    @Transaction
    @Query("SELECT * FROM customer") // ORDER BY lastName ASC
    //TODO: Do I need to return LiveData here?
    suspend fun getAllCustomers(): List<Customer>

    @Delete
    suspend fun deleteCustomer(horse: Customer)
    //TODO: What happens to all horses that belong to this customer

    // get list of horses for customer
    @Transaction
    @Query("SELECT * FROM customer WHERE customerId = :customerId")
    suspend fun getCustomerWithHorses(customerId: Int): List<CustomerWithHorses>


}