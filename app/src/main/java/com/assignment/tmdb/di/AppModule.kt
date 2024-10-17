package com.assignment.tmdb.di

import com.assignment.tmdb.network.ApiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    companion object {
        private const val API_KEY =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTgyZDE0ZDE3Y2JlYjRmZGMzN2I5MTYyMDNhNzRjYSIsIm5iZiI6MTcyOTE1ODg0Ni4xMjIyOTQsInN1YiI6IjY3MGUzM2ZiMGI4MDA1MzdkNzVjZGE5NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.WJD47QmKbzlZG6Y_5byzzMLOzmAv21BYI9UP6vDklb0"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(Interceptor {
                val request = it.request()
                val newRequest = request.newBuilder()
                    .addHeader("Authorization", "Bearer $API_KEY")
                    .build()
                it.proceed(newRequest)
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }


    @Provides
    fun provideApiClient(retrofit: Retrofit) =
        retrofit.create(ApiClient::class.java)
}