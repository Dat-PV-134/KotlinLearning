package com.its.calculator.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.its.calculator.model.TodoItem

@Dao
interface TodoItemDao {
    @Insert
    suspend fun insertTodoItem(todoItem: TodoItem): Long

    @Update
    suspend fun updateTodoItem(todoItem: TodoItem)

    @Delete
    suspend fun deleteTodoItem(todoItem: TodoItem)

    @Query("SELECT * FROM todo_table")
    fun getAllTodoItems() : LiveData<List<TodoItem>>

    @Query("SELECT * FROM todo_table")
    fun getAllTodoItems2() : List<TodoItem>
}