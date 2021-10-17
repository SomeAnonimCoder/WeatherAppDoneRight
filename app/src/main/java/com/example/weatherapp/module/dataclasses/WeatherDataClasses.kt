package com.example.weatherapp.module.dataclasses

import java.util.*
//For increase quality and normalize response


data class HourlyDataPoint(val time: Date,
                           val temp:Double,
                           val humidity:Double,
                           val status:String,
                           val wind:Double)

data class HourlyDataPoints(val hourlyDataPoints : List<HourlyDataPoint>)

data class DailyDataPoint(val time: Date,
                          val morning:Double,
                          val day:Double,
                          val evening:Double,
                          val night:Double,
                          val morning_fl:Double,
                          val day_fl:Double,
                          val evening_fl:Double,
                          val night_fl:Double,
                          val pressure:Int,
                          val wind:Double,
                          var humidity:Double,
                          val clouds:Double,
                          val status: String,
                          val sunset: Date,
                          val sunrise: Date
)
data class DailyDataPoints(val dailyDataPoints : List<DailyDataPoint>)
