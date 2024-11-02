package com.example.retrofit

import android.app.Application
import androidx.room.Room
import com.example.retrofit.data.AppDatabase
import com.example.retrofit.data.database.AppDatabase

class MyApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}