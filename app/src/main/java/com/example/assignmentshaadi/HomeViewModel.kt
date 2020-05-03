package com.example.assignmentshaadi

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignmentshaadi.retrofit.RetrofitInstance
import com.example.assignmentshaadi.retrofit.services.HomeService
import com.example.assignmentshaadi.room.DatabaseInstance
import com.example.assignmentshaadi.room.StatusProfile
import com.example.assignmentshaadi.room.entities.User
import com.example.assignmentshaadi.room.operations.GetProfilesByStatus
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {
    var compositeDisposable = CompositeDisposable()
    var results: MutableLiveData<MutableList<User>> = MutableLiveData()
    var acceptedProfiles: MutableLiveData<MutableList<User>> = MutableLiveData()
    var declinedProfiles: MutableLiveData<MutableList<User>> = MutableLiveData()
    var rowId: MutableLiveData<Long> = MutableLiveData()
    var dataAvailable: MutableLiveData<Boolean> = MutableLiveData()


    fun getProfiles(context: Context?) {
//        HomeRespository.

        // service call
        var service = RetrofitInstance.getInstance("https://randomuser.me")
            .create(HomeService::class.java)

        compositeDisposable.add(service.getResults(10)
            .subscribeOn(Schedulers.io())
            .map {

                var users = mutableListOf<User>()
                it.results?.forEach {

                    users.add(
                        User(
                            title = it.name?.title,
                            first = it.name?.first,
                            last = it.name?.last,
                            email = it.email,
                            thumbnail = it.picture?.thumbnail
                        )
                    )
                }
                users
            }
            .subscribe(
                {

                    var results = it
                    context?.let {

                        DatabaseInstance.getInstance(context).userDao()
                            .insertAll(results)
                    }
                    dataAvailable.postValue(true)
                },
                {

                    // can you any sdks like crashlytics to log the error or can view it in the LOG CAT
                    Log.d("Test", "error") //some primitive error
                })
        )
    }

    fun allProfiles(context: Context?): Unit {
        context?.let {

            GetProfilesByStatus(context,StatusProfile.SHOWN, results).execute()
        }
    }

    fun getAcceptedProfiles(context: Context?): Unit {
        context?.let {

            GetProfilesByStatus(context,StatusProfile.ACCEPTED, acceptedProfiles).execute()
        }
    }

    fun getDeclinedProfiles(context: Context?): Unit {
        context?.let {
            GetProfilesByStatus(context,StatusProfile.DECLINED,declinedProfiles).execute()
        }
    }


    fun clearDisposables(): Unit {
        compositeDisposable.clear()
    }
}