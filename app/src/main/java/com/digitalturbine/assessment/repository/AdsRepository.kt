package com.digitalturbine.assessment.repository

import com.digitalturbine.assessment.repository.apis.AdsApi
import com.digitalturbine.assessment.repository.entities.DataResult
import com.digitalturbine.assessment.repository.entities.Response
import java.lang.Exception

/**
 * Repository class containing network api
 */
class AdsRepository(private val api: AdsApi) {
    suspend fun getAdsList() : DataResult<List<Response.Ad>> =
        try {
            val result = api.getAllAds()
            DataResult.Success(result.items)
        } catch (e: Exception) {
            DataResult.Failure(e)
        }
}