package com.bignerdranch.android.criminalintent

import android.app.Application

class ListApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        ListRepository.initialize(this)
    }
}