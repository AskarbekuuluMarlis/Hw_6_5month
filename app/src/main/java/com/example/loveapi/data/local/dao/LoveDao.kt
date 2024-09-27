package com.example.loveapi.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.loveapi.data.local.entity.HistoryEntity

@Dao
interface LoveDao {

    @Insert
    fun addHistory (historyEntity: HistoryEntity)

    @Query("SELECT * FROM histories ORDER BY first_name")
    fun getHistory(): LiveData<List<HistoryEntity>>

    @Delete
    fun deleteHistory(historyEntity: HistoryEntity)
}