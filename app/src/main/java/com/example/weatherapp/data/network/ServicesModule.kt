package com.example.weatherapp.data.network

import com.example.weatherapp.di.AppScope
import com.example.weatherapp.di.WeatherApiQualifier
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi

@Module
class ServicesModule {
    @ExperimentalSerializationApi
    @Provides
    @AppScope
    fun provideWeatherService(@WeatherApiQualifier apiKey: String,cityID:Int):WeatherService{
        return WeatherService(apiKey,cityID)
    }

    @ExperimentalSerializationApi
    @Provides
    @AppScope
    fun provideForecastService(@WeatherApiQualifier apiKey: String, lat : Float, lon : Float):ForecastService{
        return ForecastService(apiKey,lat,lon)
    }
}