package com.example.retrofit.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.MyApplication
import com.example.retrofit.data.model.PercentageModel
import kotlinx.coroutines.launch

class HistoryViewModel : ViewModel() {
    fun getAllResults(callback: (List<PercentageModel>) -> Unit) {
        viewModelScope.launch {
            val results = MyApplication.database.loveDao().getAllResults()
            callback(results)
        }
    }
}