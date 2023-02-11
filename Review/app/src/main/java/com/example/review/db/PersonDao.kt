package com.example.review.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {
    @Insert
    suspend fun insertPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)

    @Query("SELECT * FROM person_table")
    fun getAllPerson(): LiveData<List<Person>>
}