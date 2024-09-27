package com.example.loveapi.ui.fragments.loveCalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapi.data.local.entity.HistoryEntity
import com.example.loveapi.data.network.model.LoveModel
import com.example.loveapi.data.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: LoveRepository): ViewModel() {

    val error: LiveData<String> = repository.error
    val flag: LiveData<Boolean> = repository.flag
    val historyList: LiveData<List<HistoryEntity>> = repository.getHistoryList()
    fun getLovePercentage(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLovePercentage(firstName, secondName)
    }

    fun deleteHistory(historyEntity: HistoryEntity) {
        repository.deleteHistory(historyEntity)
    }
}