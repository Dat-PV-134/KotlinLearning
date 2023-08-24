package com.example.tempapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classification_table")
data class Classification (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "iconId")
    val iconId: Int,
    @ColumnInfo(name = "iconColor")
    val iconColor: Int,
    @ColumnInfo(name = "iconType")
    val type: Int
)