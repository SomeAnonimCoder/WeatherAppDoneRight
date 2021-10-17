package com.example.weatherapp.data.network

import com.example.weatherapp.di.WeatherApiQualifier
import com.example.weatherapp.module.dataclasses.Cities
import com.example.weatherapp.module.dataclasses.HourlyDataPoints
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET

//Adding retrofit and okhttp
interface WeatherService {
    @GET("https://api.openweathermap.org/data/2.5/weather?id={cityID}&units=metric&appid={apiKey}")
    fun getCurrentWeather(cityID:Int,@WeatherApiQualifier apiKey:String ): HourlyDataPoints
}

@ExperimentalSerializationApi
fun WeatherService(apiKey: String,cityID:Int): WeatherService {

    //creating client and observe request
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{chain ->
            val authorizedRequest = chain.request().newBuilder()
                .addHeader("apiKey",apiKey)
                .addHeader("cityID", cityID.toString())
                .build()
            chain.proceed(authorizedRequest)
        }
        .build()

    //creating request for
    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    return retrofit.create(WeatherService::class.java)
}