package com.example.assignmentshaadi.room.operations

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.example.assignmentshaadi.room.StatusProfile
import com.example.assignmentshaadi.room.entities.User
import com.example.assignmentshaadi.room.DatabaseInstance

class GetProfilesByStatus(val context: Context, val status : StatusProfile, val data : MutableLiveData<MutableList<User>>) : AsyncTask<Void, Void, MutableList<User>>() {

    override fun doInBackground(vararg p0: Void?): MutableList<User> {

        return DatabaseInstance.getInstance(context).userDao().getAllByStatus(status)
    }

    override fun onPostExecute(result: MutableList<User>?) {
        super.onPostExecute(result)
        data.value = result
    }
}