package com.example.assignmentshaadi.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.assignmentshaadi.room.StatusProfile

@Entity()
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String? = null,
    val first: String? = null,
    val last: String? = null,
    val email: String? = null,
    val thumbnail: String? = null,
    @ColumnInfo(name = "status")
    var status: StatusProfile = StatusProfile.SHOWN
){

}