package com.its.calculator.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.its.calculator.model.Classification

@Dao
interface ClassificationDao {
    @Insert
    suspend fun insertClassification(classification: Classification): Long

    @Update
    suspend fun updateClassification(classification: Classification)

    @Delete
    suspend fun deleteClassification(classification: Classification)

    @Query("SELECT * FROM classification_table")
    fun getAllClassification(): List<Classification>
}