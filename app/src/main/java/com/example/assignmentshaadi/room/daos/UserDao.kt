package com.example.assignmentshaadi.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignmentshaadi.room.StatusProfile
import com.example.assignmentshaadi.room.entities.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): MutableList<User>

    @Query("SELECT * FROM user where status=:status")
    fun getAllByStatus(status: StatusProfile): MutableList<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertdata(data: User)

    @Insert()
    fun insertAll(data: MutableList<User>?)

    @Query("UPDATE user SET status = :status WHERE id = :id")
    fun updateStatus(id: Int, status: StatusProfile) : Long

}