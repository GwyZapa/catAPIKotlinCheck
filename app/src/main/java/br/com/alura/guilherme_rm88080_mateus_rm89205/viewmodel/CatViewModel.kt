package br.com.alura.guilherme_rm88080_mateus_rm89205.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import CatApiService
import br.com.alura.guilherme_rm88080_mateus_rm89205.models.CatModel

class CatViewModel(application: Application) : AndroidViewModel(application) {
    private val catApiService = CatApiService.create()

    private val _cats = MutableLiveData<List<CatModel>>()
    val cats: LiveData<List<CatModel>> = _cats

    suspend fun getCats(apiKey: String, limit: Int) {
        val catList = catApiService.getCats(apiKey, limit)
        _cats.value = catList
    }
}
