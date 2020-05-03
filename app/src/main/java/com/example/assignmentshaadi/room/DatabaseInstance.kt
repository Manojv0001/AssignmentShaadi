package com.example.assignmentshaadi.room

import android.content.Context
import androidx.room.Room

class DatabaseInstance {

    companion object
    {
        fun getInstance(context: Context) : AppDatabase
        {
            val instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "db"
            )
                .build()

            return instance
        }
    }




}