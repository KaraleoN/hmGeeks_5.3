package com.example.retrofit.ui.presenter

import com.example.retrofit.data.model.PercentageModel

interface ILoveCalculatorView {
    fun showResult(percentageModel: PercentageModel)
    fun showError(message: String)
}