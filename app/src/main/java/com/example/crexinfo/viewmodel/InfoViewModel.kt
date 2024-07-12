package com.example.crexinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crexinfo.api.model.MatchInfoNetwork
import com.example.crexinfo.repository.MatchInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfoViewModel(private val infoRepository: MatchInfoRepository) :
    ViewModel() {

    val infoLiveData: LiveData<MatchInfoNetwork> = infoRepository.infoLiveData

    fun fetchInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            infoRepository.fetchData()
        }
    }
}