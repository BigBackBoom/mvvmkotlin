package com.bigbackboom.mvvm_kotlin.di.module

import com.bigbackboom.mvvm_kotlin.EnvConfig
import com.bigbackboom.mvvm_kotlin.data.remote.GitHubAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RepositoryModule {

    companion object {
        private const val API_DEFAULT_TIMEOUT_SECONDS = 30
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            connectTimeout(API_DEFAULT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            readTimeout(API_DEFAULT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            writeTimeout(API_DEFAULT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    @Singleton
    fun provideGitHubAPI(client: OkHttpClient): GitHubAPI {
        return createApiClient(GitHubAPI::class.java, EnvConfig.BASE_GITHUB_URL, client)
    }

    private fun <T> createApiClient(
        clazz: Class<T>,
        baseUrl: String,
        client: OkHttpClient
    ): T {
        return createApiClient(clazz, baseUrl, client, GsonConverterFactory.create())
    }

    private fun <T> createApiClient(
        clazz: Class<T>,
        baseUrl: String,
        client: OkHttpClient,
        factory: Converter.Factory
    ): T {

        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .build()
            .create(clazz)
    }

}
