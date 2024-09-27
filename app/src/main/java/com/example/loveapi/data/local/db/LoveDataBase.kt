package com.example.loveapi.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loveapi.data.local.dao.LoveDao
import com.example.loveapi.data.local.entity.HistoryEntity

@Database (entities = [HistoryEntity::class], version = 1)
abstract class LoveDataBase: RoomDatabase() {

    abstract fun getHistoryDao(): LoveDao
}