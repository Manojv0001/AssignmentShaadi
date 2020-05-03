package com.example.assignmentshaadi.room.operations

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.example.assignmentshaadi.room.DatabaseInstance
import com.example.assignmentshaadi.room.entities.User


class GetAllProfiles(val context: Context,val data : MutableLiveData<MutableList<User>>) : AsyncTask<Void, Void, MutableList<User>>() {

    override fun doInBackground(vararg p0: Void?): MutableList<User> {

        return DatabaseInstance.getInstance(context).userDao().getAll()
    }

    override fun onPostExecute(result: MutableList<User>?) {
        super.onPostExecute(result)
        data.value = result
    }
}