package studio.stilip.tensorkinopoisk.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import studio.stilip.tensorkinopoisk.domain.entities.Actor
import java.lang.reflect.Type


class DataConverter {

    @TypeConverter
    fun fromStringToListString(value: String?): List<String> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromListStringToString(list: List<String>): String = Gson().toJson(list)

    @TypeConverter
    fun fromStringToActor(string: String): Actor {
        return Gson().fromJson(string, Actor::class.java)
    }

    @TypeConverter
    fun fromActorToString(value: Actor): String = Gson().toJson(value)

    @TypeConverter
    fun fromStringToListActor(value: String?): List<Actor> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Actor?>?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromListActorToString(list: List<Actor>): String = Gson().toJson(list)

}