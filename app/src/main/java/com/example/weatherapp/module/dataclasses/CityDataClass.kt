package com.example.weatherapp.module.dataclasses

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//заполнить

@Parcelize
@Entity(tableName = "cities")
data class CityDataClass (
    @PrimaryKey(autoGenerate = true)
    val id: Int
    ): Parcelable
