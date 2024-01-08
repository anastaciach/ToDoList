package com.bignerdranch.android.todolist.database;

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.todolist.ListItem


@Database(entities = [ ListItem::class ], version=1)
@TypeConverters(ListTypeConverters::class)

abstract class ListDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
}