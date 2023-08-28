package com.tools.myappforlearning.crud.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.concurrent.Flow

@Dao
interface AnimalDao {
    @Insert
    suspend fun insertAnimal(animal: Animal)

    @Update
    suspend fun updateAnimal(animal: Animal)

    @Delete
    suspend fun deleteAnimal(animal: Animal)

    @Query("DELETE FROM animal_table")
    suspend fun deleteAllAnimal()

    @Query("SELECT * FROM animal_table")
    fun getAllAnimal(): LiveData<List<Animal>>
}