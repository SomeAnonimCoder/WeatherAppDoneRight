package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.BuildConfig

class WeatherApp : Application(){
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .apiKey(BuildConfig.WeatherApiKey)
            .application(this)
            .build()
    }
}