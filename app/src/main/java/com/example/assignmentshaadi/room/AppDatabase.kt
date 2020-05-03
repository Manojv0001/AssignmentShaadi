package com.example.assignmentshaadi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assignmentshaadi.room.daos.UserDao
import com.example.assignmentshaadi.room.entities.User
import com.example.assignmentshaadi.utilities.StatusConverters

@Database(entities = arrayOf(User::class), version = 1)
@TypeConverters(StatusConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
