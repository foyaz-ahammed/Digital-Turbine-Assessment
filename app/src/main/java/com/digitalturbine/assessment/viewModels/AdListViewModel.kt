package com.digitalturbine.assessment.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalturbine.assessment.repository.AdsRepository
import com.digitalturbine.assessment.repository.entities.DataResult
import com.digitalturbine.assessment.repository.entities.LoadResult
import com.digitalturbine.assessment.repository.entities.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * [ViewModel] containing list of data
 */
class AdListViewModel(private val repository: AdsRepository): ViewModel() {
    companion object {
        val TAG = AdListViewModel::class.java.simpleName
    }

    private val _adList = MutableLiveData<List<Response.Ad>>()
    private val _loading = MutableLiveData<LoadResult>()

    val adList: LiveData<List<Response.Ad>>
        get() = _adList
    val loading: LiveData<LoadResult>
        get() = _loading

    private suspend fun fetchData(): DataResult<List<Response.Ad>> =
        withContext(Dispatchers.IO) {
            return@withContext repository.getAdsList()
        }

    fun loadData() {
        viewModelScope.launch {
            _loading.value = LoadResult.LOADING
            when(val result = fetchData()) {
                is DataResult.Success -> {
                    _adList.value = result.data
                    _loading.value = LoadResult.SUCCESS
                }
                is DataResult.Failure -> {
                    Log.w(TAG, result.exception)
                    _loading.value = LoadResult.FAIL
                }
            }
        }
    }
}