package com.example.weatherapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.module.dataclasses.CityDataClass


@Database(entities = [CityDataClass::class],version = 1,exportSchema = false)
abstract class CityDatabase : RoomDatabase() {
    abstract fun cityDao() : CityDao

    companion object{
        @Volatile
        private var INSTANCE : CityDatabase? = null

        fun getDatabase(context: Context) : CityDatabase {
            val tempInstance = INSTANCE
            if (tempInstance !=null) return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CityDatabase::class.java,
                    "cities"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
