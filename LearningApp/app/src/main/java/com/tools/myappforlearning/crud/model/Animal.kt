package com.tools.myappforlearning.crud.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_table")
data class Animal(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "animal_id")
    val id: Int,
    @ColumnInfo(name = "animal_name")
    val name: String,
    @ColumnInfo(name = "animal_type")
    val type: String
)
