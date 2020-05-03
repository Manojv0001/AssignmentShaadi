package com.example.assignmentshaadi

import android.content.Context
import com.example.assignmentshaadi.room.DatabaseInstance
import io.reactivex.disposables.CompositeDisposable

class HomeRespository
{
    var compositeDisposable = CompositeDisposable()

    fun getAllProfiles(context : Context)
    {
        var result = DatabaseInstance.getInstance(context).userDao().getAll()
    }
}