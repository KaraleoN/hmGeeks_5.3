package com.example.retrofit.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofit.data.model.PercentageModel

@Database(entities = [PercentageModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loveDao(): LoveDao
}