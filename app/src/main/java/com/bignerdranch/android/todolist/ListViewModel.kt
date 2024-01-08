package com.bignerdranch.android.todolist

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.criminalintent.ListRepository

class ListViewModel : ViewModel() {
    private val listRepository = ListRepository.get()
    val ListLiveData  = listRepository.getLists()
    fun addList(list: ListItem) {
        listRepository.addList(list)
    }
}