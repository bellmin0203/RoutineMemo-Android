package com.jm.thinkup.database.util

import androidx.room.TypeConverter
import com.jm.thinkup.domain.model.RepeatType
import kotlinx.serialization.json.Json

class RepeatTypeConverter {

    @TypeConverter
    fun fromRepeatType(repeatType: RepeatType?): String? {
        return repeatType?.let {
            Json.encodeToString(it)
        }
    }

    @TypeConverter
    fun toRepeatType(repeatTypeString: String?): RepeatType? {
        return repeatTypeString?.let {
            Json.decodeFromString(it)
        }
    }
}