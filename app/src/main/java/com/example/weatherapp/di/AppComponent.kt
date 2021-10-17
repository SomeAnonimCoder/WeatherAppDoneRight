package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.data.network.ServicesModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Scope

@[AppScope Component(modules = [AppModule::class, ServicesModule::class])]
interface AppComponent{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application):Builder

        @BindsInstance
        fun apiKey(@WeatherApiQualifier apiKey : String): Builder

        fun build():AppComponent
    }
}

@Module
class AppModule{

}

@Qualifier
annotation class WeatherApiQualifier

@Scope
annotation class AppScope