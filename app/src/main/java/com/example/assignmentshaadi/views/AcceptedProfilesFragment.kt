package com.example.assignmentshaadi.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentshaadi.HomeViewModel
import com.example.assignmentshaadi.R
import com.example.assignmentshaadi.views.adapters.AcceptedProfilesRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_accepted_profiles.recycler_view

class AcceptedProfilesFragment : Fragment()
{
    lateinit var viewModel : HomeViewModel

    companion object{

        fun newInstance() : AcceptedProfilesFragment
        {
            var fragment = AcceptedProfilesFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = HomeViewModel()
        viewModel.acceptedProfiles.observe(this, Observer {

            (recycler_view.adapter as AcceptedProfilesRecyclerAdapter).setData(it)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_accepted_profiles,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.adapter = AcceptedProfilesRecyclerAdapter(this.context)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        var itemDecorator = DividerItemDecoration(activity,LinearLayoutManager.VERTICAL)
        itemDecorator.setDrawable(resources.getDrawable(R.drawable.bottom_divider))
        recycler_view.addItemDecoration(itemDecorator)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAcceptedProfiles(this.context)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposables()
    }
}