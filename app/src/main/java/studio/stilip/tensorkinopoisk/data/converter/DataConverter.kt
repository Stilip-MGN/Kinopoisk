package studio.stilip.tensorkinopoisk.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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

}