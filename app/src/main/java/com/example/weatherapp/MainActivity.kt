package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.weatherapp.data.CityDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db:CityDatabase = databaseBuilder(
//            applicationContext,
//            CityDatabase::class.java, "database-name"
//        ).build()
    }
}