package com.mercadolibre.di

import com.mercadolibre.models.api.StoreApi
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * CLass used to manage the network access from apis
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 **/
class NetworkModule(private val storeApiUrl: String) {
    companion object {
        const val okHttpClientWithoutInterceptor = "defaultOkHttpClient"
        const val retrofitStore = "retrofitStore"
        private const val DEFAULT_TIME_OUT = 60L
    }

    /**
     * Initialize the module withe the respective retrofit information
     * */
    fun initModule(): Module {
        return module {

            // Retrofit and OkHttpClient instances
            single(named(okHttpClientWithoutInterceptor)) { provideDefaultOkHttpClient() }
            single(named(retrofitStore)) { provideRetrofitStoreClient(get(named(okHttpClientWithoutInterceptor))) }
            // API
            single { provideStoreApi(get(named(retrofitStore))) }
        }
    }

    /**
     * OkHttpClient without Interceptor
     */
    private fun provideDefaultOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Retrofit store clients
     */
    private fun provideRetrofitStoreClient(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(storeApiUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}


private fun provideStoreApi(retrofit: Retrofit): StoreApi = retrofit.create(StoreApi::class.java)
