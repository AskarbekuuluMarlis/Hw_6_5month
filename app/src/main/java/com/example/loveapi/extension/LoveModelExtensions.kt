package com.example.loveapi.extension

import com.example.loveapi.data.local.entity.HistoryEntity
import com.example.loveapi.data.network.model.LoveModel

fun LoveModel.toEntity(): HistoryEntity{
    return HistoryEntity(
        firstName = this.firstName,
        secondName = this.secondName,
        percentage = this.percentage
    )
}