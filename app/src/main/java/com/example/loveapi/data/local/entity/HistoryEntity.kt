package com.example.loveapi.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "histories")
data class HistoryEntity(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo (name = "first_name") val firstName: String,
    @ColumnInfo (name = "second_name") val secondName: String,
    @ColumnInfo (name = "percent") val percentage: String,
){

}
