package com.example.weatherapp.data.network

import com.example.weatherapp.di.WeatherApiQualifier
import com.example.weatherapp.module.dataclasses.DailyDataPoint
import com.example.weatherapp.module.dataclasses.DailyDataPoints
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET

interface ForecastService {
    @GET("https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&units=metric&appid={apiKey}")
    fun getForecastWeather(lat:Float, lon : Float,@WeatherApiQualifier apiKey : String): DailyDataPoints
}
@ExperimentalSerializationApi
fun ForecastService(apiKey: String, lat : Float, lon : Float): ForecastService {

    //creating client and observe request
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{chain ->
            val authorizedRequest = chain.request().newBuilder()
                .addHeader("apiKey",apiKey)
                .addHeader("lat",lat.toString())
                .addHeader("lon",lon.toString())
                .build()
            chain.proceed(authorizedRequest)
        }
        .build()

    //creating request for
    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    return retrofit.create(ForecastService::class.java)
}