package com.digitalturbine.assessment.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digitalturbine.assessment.repository.entities.Response

/**
 * [ViewModel] containing app detailed information
 */
class AdDetailViewModel: ViewModel() {
    private val _liveData = MutableLiveData<Response.Ad>()
    val liveData: LiveData<Response.Ad>
        get() = _liveData

    fun updateData(data: Response.Ad) {
        _liveData.value = data
    }
}