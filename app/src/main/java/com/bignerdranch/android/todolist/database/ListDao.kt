package com.bignerdranch.android.todolist.database;

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bignerdranch.android.todolist.ListItem
import java.util.UUID

@Dao

interface ListDao {
    @Query("SELECT * FROM list ORDER BY priority")
    fun getLists(): LiveData<List<ListItem>>
    @Query("SELECT * FROM list WHERE id=(:id)")
    fun getList(id: UUID): LiveData<ListItem?>

    @Update
    fun updateList(list: ListItem)
    @Insert
    fun addList(list: ListItem)
    @Query("DELETE FROM list WHERE id=(:id)")
    fun deleteList(id: UUID)
}