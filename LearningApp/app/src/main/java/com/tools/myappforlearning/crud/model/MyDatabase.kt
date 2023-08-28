package com.tools.myappforlearning.crud.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Animal::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract val animalDao : AnimalDao

    companion object {
        private var INSTANCE : MyDatabase? = null

        fun getInstance(context : Context) : MyDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "my_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}