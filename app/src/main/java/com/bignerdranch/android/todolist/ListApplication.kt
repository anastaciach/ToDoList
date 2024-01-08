package com.bignerdranch.android.todolist

import android.app.Application
import com.bignerdranch.android.todolist.ListRepository

class ListApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        ListRepository.initialize(this)
    }
}