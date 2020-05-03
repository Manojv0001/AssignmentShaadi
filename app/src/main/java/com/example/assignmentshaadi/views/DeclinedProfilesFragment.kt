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
import com.example.assignmentshaadi.views.adapters.DeclinedProfilesRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_declined_profiles.*

class DeclinedProfilesFragment : Fragment()
{
    lateinit var viewModel : HomeViewModel

    companion object{

        fun newInstance() : DeclinedProfilesFragment
        {
            var fragment = DeclinedProfilesFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = HomeViewModel()
        viewModel.declinedProfiles.observe(this, Observer {

            (recycler_view.adapter as DeclinedProfilesRecyclerAdapter).setData(it)
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_declined_profiles,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.adapter = DeclinedProfilesRecyclerAdapter(this.context)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        var itemDecorator = DividerItemDecoration(activity,LinearLayoutManager.VERTICAL)
        itemDecorator.setDrawable(resources.getDrawable(R.drawable.bottom_divider))
        recycler_view.addItemDecoration(itemDecorator)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDeclinedProfiles(this.context)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposables()
    }
}