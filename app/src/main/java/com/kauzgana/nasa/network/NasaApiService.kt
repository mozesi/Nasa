package com.kauzgana.nasa.network

import com.kauzgana.nasa.models.MarsProperty
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://mars.udacity.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface NasaApiService{
        @GET("realestate")
      suspend  fun getProperties(): List<MarsProperty>
    }

    object NasaApi{
        val retrofitService: NasaApiService by lazy {
            retrofit.create(NasaApiService::class.java)
        }
    }