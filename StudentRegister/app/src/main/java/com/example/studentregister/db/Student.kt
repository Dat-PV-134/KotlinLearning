package com.example.studentregister.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name = "email")
    var email : String
)