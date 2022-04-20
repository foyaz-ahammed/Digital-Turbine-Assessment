package com.digitalturbine.assessment.repository.entities

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Network response class
 */
class Response {
    @Root(name = "ads", strict = false)
    data class Ads constructor(
        @field:ElementList(name="ad", inline=true)
        val items: List<Ad> = emptyList()
    )

    @Root(name = "ad", strict = false)
    data class Ad constructor(
        @field:Element(name="appId")
        val appId: String = "",

        @field:Element(name="averageRatingImageURL")
        val averageRatingImageURL: String? = null,

        @field:Element(name="bidRate")
        val bidRate: Float = 0f,

        @field:Element(name="billingTypeId")
        val billingTypeId: String? = null,

        @field:Element(name="callToAction")
        val callToAction: String? = null,

        @field:Element(name="campaignDisplayOrder")
        val campaignDisplayOrder: Int = 0,

        @field:Element(name="campaignId")
        val campaignId: String? = null,

        @field:Element(name="campaignTypeId")
        val campaignTypeId: String? = null,

        @field:Element(name="categoryName")
        val categoryName: String? = null,

        @field:Element(name="clickProxyURL")
        val clickProxyURL: String? = null,

        @field:Element(name="creativeId")
        val creativeId: String? = null,

        @field:Element(name="homeScreen")
        val homeScreen: Boolean = false,

        @field:Element(name="impressionTrackingURL")
        val impressionTrackingURL: String? = null,

        @field:Element(name="isRandomPick")
        val isRandomPick: Boolean = false,

        @field:Element(name="minOSVersion", required = false)
        val minOSVersion: String? = null,

        @field:Element(name="numberOfRatings")
        val numberOfRatings: String? = null,

        @field:Element(name="productDescription")
        val productDescription: String = "",

        @field:Element(name="productId")
        val productId: String = "",

        @field:Element(name="productName")
        val productName: String = "",

        @field:Element(name="productThumbnail")
        val productThumbnail: String? = null,

        @field:Element(name="rating")
        val rating: Float = 0f,

        @field:Element(name="numberOfDownloads")
        val numberOfDownloads: String? = null
    )
}