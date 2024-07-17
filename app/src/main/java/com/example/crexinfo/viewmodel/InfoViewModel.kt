package com.example.crexinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
import com.example.crexinfo.repository.MatchInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfoViewModel(private val infoRepository: MatchInfoRepository) :
    ViewModel() {

    val infoLiveData: LiveData<MatchInfoViewData> = infoRepository.infoLiveData

    fun fetchInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            infoRepository.fetchData()
        }
    }

    fun fetchInfoFromFirebase() {
        viewModelScope.launch(Dispatchers.IO) {
            infoRepository.fetchDataFromFirebase()
        }
    }
}