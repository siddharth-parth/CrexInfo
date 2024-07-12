package com.example.crexinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.crexinfo.repository.MatchInfoRepository

class InfoViewModelFactory(
    private val infoRepository: MatchInfoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfoViewModel(infoRepository) as T
    }
}