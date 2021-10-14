package com.example.weatherapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.weatherapp.module.dataclasses.CityDataClass

@Dao
interface CityDao {

    @Query("SELECT * FROM cities WHERE name LIKE '%:string%' ORDER by id ASC")
    fun readNeededData(string:String): LiveData<List<CityDataClass>>

}