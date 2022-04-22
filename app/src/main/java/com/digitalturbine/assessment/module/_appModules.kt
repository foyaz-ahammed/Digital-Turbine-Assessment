package com.digitalturbine.assessment.module

import com.digitalturbine.assessment.repository.AdsRepository
import com.digitalturbine.assessment.repository.apis.AdsApi
import com.digitalturbine.assessment.util.Constants
import com.digitalturbine.assessment.viewModels.AdDetailViewModel
import com.digitalturbine.assessment.viewModels.AdListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

// Define koin modules
val networkModule = module {
    single { provideRetrofit(get()) }
    single { provideOkHttpClient() }
    single { provideApi(get()) }
}

val repositoryModule = module {
    single { AdsRepository(get()) }
}

val viewModelModule = module {
    single { AdListViewModel(get()) }
    single { AdDetailViewModel() }
}

/**
 * @return [Retrofit] instance
 */
private fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(SimpleXmlConverterFactory.create()) // As JAXB convert is not working on Android, I used this deprecated library
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

/**
 * @return [OkHttpClient] instance
 */
private fun provideOkHttpClient() = OkHttpClient.Builder()
    .readTimeout(10L, TimeUnit.SECONDS)
    .readTimeout(15L, TimeUnit.SECONDS)
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .build()

/**
 * @return [AdsApi] instance
 */
private fun provideApi(retrofit: Retrofit): AdsApi = retrofit.create(AdsApi::class.java)