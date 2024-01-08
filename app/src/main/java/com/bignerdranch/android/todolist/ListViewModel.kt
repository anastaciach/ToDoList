package com.bignerdranch.android.todolist

import androidx.lifecycle.ViewModel
import java.util.UUID

class ListViewModel : ViewModel() {
    private val listRepository = ListRepository.get()
    val ListLiveData  = listRepository.getLists()
    fun addList(list: ListItem) {
        listRepository.addList(list)
    }
    fun deleteList(listId: UUID) {
        listRepository.deleteList(listId)
    }
}