package com.its.calculator.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.its.calculator.model.Classification
import com.its.calculator.model.TodoItem

@Database(entities = [TodoItem::class, Classification::class], version = 2, exportSchema = false)
abstract class TodoItemDatabase : RoomDatabase() {
    abstract fun todoItemDao() : TodoItemDao

    abstract fun classificationDao(): ClassificationDao

    companion object {
        @Volatile
        private var INSTANCE: TodoItemDatabase? = null

        fun getInstance(context : Context) : TodoItemDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoItemDatabase::class.java,
                        "todo_database"
                    ).build()
                }
                return instance
            }
        }
    }
}