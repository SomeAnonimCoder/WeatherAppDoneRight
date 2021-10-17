package com.example.weatherapp.module.dataclasses

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cities")
data class CityDataClass (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val country: String,
    val lon: Float,
    val lat: Float
    ): Parcelable

data class Cities(val cities : List<CityDataClass>)
