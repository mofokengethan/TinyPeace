package com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class IconViewModel(model: IconModel) {
    private var _showIcon = MutableLiveData<Boolean>()
    var showIcon: LiveData<Boolean> = _showIcon
    var icon: IconModel

    init {
        _showIcon.value = model.showIcon
        icon = model
    }
}
