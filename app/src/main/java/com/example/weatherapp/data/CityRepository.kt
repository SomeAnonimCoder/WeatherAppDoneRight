package com.example.weatherapp.data

import androidx.lifecycle.LiveData
import com.example.weatherapp.module.dataclasses.CityDataClass

class CityRepository (private val cityDao : CityDao){
    fun readNeededData(name:String): LiveData<List<CityDataClass>> {
        return cityDao.readNeededData(name)
    }
}
