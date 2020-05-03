package com.example.assignmentshaadi.room.operations

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.example.assignmentshaadi.room.StatusProfile
import com.example.assignmentshaadi.room.DatabaseInstance

class UpdateStatus(val context: Context, val id:Int, val status : StatusProfile, val data : MutableLiveData<Long>) : AsyncTask<Void, Void, Long>() {

    override fun doInBackground(vararg p0: Void?): Long {

        return DatabaseInstance.getInstance(context).userDao().updateStatus(id,status)
    }

    override fun onPostExecute(result: Long) {
        super.onPostExecute(result)
        data.value = result
    }
}