package com.example.weatherapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import com.example.weatherapp.module.dataclasses.CityDataClass

@Dao
interface CityDao {
    @Query("SELECT * FROM cities WHERE name LIKE :string ORDER by id ASC")
    fun readNeededData(string:String): LiveData<List<CityDataClass>>
    //needed refactored string "ser" -> "%ser%"
}