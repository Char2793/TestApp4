package com.example.chewbaccaapp.di

import com.example.chewbaccaapp.data.network.StarWarsApi
import com.example.chewbaccaapp.data.network.StarWarsDataSource
import com.example.chewbaccaapp.data.repository.StarWarsRepo
import com.example.chewbaccaapp.domain.StarWarsDataSourceImpl
import com.example.chewbaccaapp.domain.StarWarsRepoImpl
import com.example.chewbaccaapp.utils.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StarWarsModule {

  /*  @Provides
    @Singleton
    fun providesMoshiConverter(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .add(ApplicationJsonAdapterFactory)
                .build()
        )
    }*/

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun providesOKHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesStarWarsApi(
        okHttpClient: OkHttpClient
    ): StarWarsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesDataSource(
        api: StarWarsApi
    ): StarWarsDataSource = StarWarsDataSourceImpl(api)


    @Provides
    @Singleton
    fun providesStarWarsRepo(
        dataSource: StarWarsDataSource
    ): StarWarsRepo = StarWarsRepoImpl(dataSource)

}



