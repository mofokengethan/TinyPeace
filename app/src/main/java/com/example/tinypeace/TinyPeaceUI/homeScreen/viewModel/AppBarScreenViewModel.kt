package com.example.tinypeace.TinyPeaceUI.homeScreen.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType

class AppBarViewModel : ViewModel() {
    private val _appBarType = MutableLiveData<com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType>()
    val appBarType: LiveData<com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType> = _appBarType

    fun setAppBarType(type: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType) {
        _appBarType.value = type
    }
}