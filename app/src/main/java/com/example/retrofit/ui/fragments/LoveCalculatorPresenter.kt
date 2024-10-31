package com.example.retrofit.ui.presenter

import com.example.retrofit.data.Services.RetrofitService
import com.example.retrofit.data.model.PercentageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorPresenter(private val view: ILoveCalculatorView) : ILoveCalculatorPresenter {

    override fun calculateLovePercentage(firstName: String, secondName: String) {
        RetrofitService.api.fetchPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "ваш_ключ_здесь",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : Callback<PercentageModel> {
            override fun onResponse(call: Call<PercentageModel>, response: Response<PercentageModel>) {
                if (response.isSuccessful && response.body() != null) {
                    view.showResult(response.body()!!)
                } else {
                    view.showError("Ошибка: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PercentageModel>, t: Throwable) {
                view.showError("Не удалось загрузить данные: ${t.localizedMessage}")
            }
        })
    }
}