package com.example.composeapp.data.local

import androidx.room.TypeConverter
import com.example.composeapp.data.models.Dimensions
import com.example.composeapp.data.models.Meta
import com.example.composeapp.data.models.Review
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>): String = gson.toJson(value)

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromDimensions(value: Dimensions): String = gson.toJson(value)

    @TypeConverter
    fun toDimensions(value: String): Dimensions = gson.fromJson(value, Dimensions::class.java)

    @TypeConverter
    fun fromMeta(value: Meta): String = gson.toJson(value)

    @TypeConverter
    fun toMeta(value: String): Meta = gson.fromJson(value, Meta::class.java)

    @TypeConverter
    fun fromReviewList(value: List<Review>): String = gson.toJson(value)

    @TypeConverter
    fun toReviewList(value: String): List<Review> {
        val listType = object : TypeToken<List<Review>>() {}.type
        return gson.fromJson(value, listType)
    }
}
