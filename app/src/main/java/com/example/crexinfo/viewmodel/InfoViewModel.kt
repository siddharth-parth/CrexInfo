package com.example.crexinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
import com.example.crexinfo.repository.MatchInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfoViewModel(private val infoRepository: MatchInfoRepository) :
    ViewModel() {

    private val _infoLiveData: MutableLiveData<MatchInfoViewData> = MutableLiveData()
    val infoLiveData: LiveData<MatchInfoViewData> = _infoLiveData

    // collects the match info data from API and posts it in [_infoLiveData]
    fun fetchInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            infoRepository.fetchData().collect { matchInfo ->
                _infoLiveData.postValue(matchInfo)
            }
        }
    }

    // collects the match info data from Firebase and posts it in [_infoLiveData]
    fun fetchInfoFromFirebase() {
        viewModelScope.launch(Dispatchers.IO) {
            infoRepository.fetchDataFromFirebase().collect { matchInfo ->
                _infoLiveData.postValue(matchInfo)
            }
        }
    }
}