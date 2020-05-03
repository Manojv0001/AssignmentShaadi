package com.example.assignmentshaadi.utilities

import androidx.room.TypeConverter
import com.example.assignmentshaadi.room.StatusProfile

class StatusConverters{

    @TypeConverter
    fun fromEnum(statusProfile: StatusProfile) : Int
    {
        when(statusProfile)
        {
            StatusProfile.SHOWN -> return 0
            StatusProfile.ACCEPTED -> return 1
            StatusProfile.DECLINED -> return 2
        }
    }

    @TypeConverter
    fun toEnum(value:Int) : StatusProfile
    {
        when(value)
        {
            0 -> return StatusProfile.SHOWN
            1 -> return StatusProfile.ACCEPTED
            2 -> return StatusProfile.DECLINED
        }
        return StatusProfile.SHOWN
    }
}