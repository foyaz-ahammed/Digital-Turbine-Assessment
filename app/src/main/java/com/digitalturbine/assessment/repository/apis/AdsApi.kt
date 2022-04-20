package com.digitalturbine.assessment.repository.apis

import com.digitalturbine.assessment.BuildConfig
import com.digitalturbine.assessment.repository.entities.Response
import com.digitalturbine.assessment.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API interface defining endpoint functions
 */
interface AdsApi {
    @GET("getAds")
    suspend fun getAllAds(
        @Query("id") id: Int = Constants.ID,
        @Query("password") password: String = Constants.PASSWORD,
        @Query("siteId") siteId: Int = Constants.SITE_ID,
        @Query("deviceId") deviceId: Int = Constants.DEVICE_ID,
        @Query("sessionId") sessionId: String = Constants.SESSION_ID,
        @Query("totalCampaignsRequested") totalCampaignsRequested: Int = Constants.TOTAL_CAMPAIGNS_REQUESTED,
        @Query("lname") lname: String = BuildConfig.LAST_NAME
    ): Response.Ads
}