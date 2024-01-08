package com.bignerdranch.android.criminalintent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.bignerdranch.android.todolist.database.ListDatabase
import com.bignerdranch.android.todolist.ListItem
import com.sample.todolist.database.ListDatabase
import java.util.UUID
import java.util.concurrent.Executors

private const val DATABASE_NAME = "list"
class ListRepository private constructor(context: Context) {
    private val database: ListDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            ListDatabase::class.java,
            DATABASE_NAME
        )
        .build()
    private val listDao = database.listDao()
    private val executor = Executors.newSingleThreadExecutor()
    fun getLists(): LiveData<List<ListItem>> = listDao.getLists()

    fun getList(id: UUID): LiveData<ListItem?> = listDao.getList(id)

    fun addList(list: ListItem) {
        executor.execute {
            listDao.addList(list)
        }
    }

    companion object {
        private var INSTANCE: ListRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE =
                    ListRepository(context)
            }
        }
        fun get(): ListRepository {
            return INSTANCE ?:
            throw
            IllegalStateException("ListRepository must be initialized")
        }
    }

}