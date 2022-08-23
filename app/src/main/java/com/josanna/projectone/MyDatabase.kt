package com.josanna.projectone

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.josanna.projectone.entities.Customer
import com.josanna.projectone.entities.Entry
import com.josanna.projectone.entities.Horse
import com.josanna.projectone.entities.User

@Database(
    entities = [
        Customer::class,
        Entry::class,
        Horse::class,
        User::class
    ],
    version = 1
)

abstract class MyDatabase : RoomDatabase(){

    abstract val myDao: MyDao

    //singleton
    companion object {
        // if value of INSTANCE is changed, it's immediately visible
        // to other threads
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            // only one threaad at a time can access database
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}