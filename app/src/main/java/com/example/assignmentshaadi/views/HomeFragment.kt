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
import com.example.assignmentshaadi.room.StatusProfile
import com.example.assignmentshaadi.room.entities.User
import com.example.assignmentshaadi.room.operations.UpdateStatus
import com.example.assignmentshaadi.views.adapters.HomeRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),View.OnClickListener
{
    lateinit var viewModel : HomeViewModel
    var user : User? = null

    companion object{

        fun newInstance() : HomeFragment
        {
            var fragment = HomeFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = HomeViewModel()
        viewModel.getProfiles(this.context)
        viewModel.results.observe(this, Observer {

            (recycler_view.adapter as HomeRecyclerAdapter).setData(it)
        })
        viewModel.rowId.observe(this, Observer {

            user?.let {

                (recycler_view.adapter as HomeRecyclerAdapter).remove(it)
                user = null
            }

        })
        viewModel.dataAvailable.observe(this, Observer {
            if(it)
            {
                viewModel.allProfiles(this.context)
                viewModel.dataAvailable.value = false
            }

        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.adapter = HomeRecyclerAdapter(this.context,this)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        var itemDecorator = DividerItemDecoration(activity,LinearLayoutManager.VERTICAL)
        itemDecorator.setDrawable(resources.getDrawable(R.drawable.bottom_divider))
        recycler_view.addItemDecoration(itemDecorator)
    }

    override fun onResume() {
        super.onResume()
        viewModel.allProfiles(this.context)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposables()
    }

    override fun onClick(view: View?) {

        var tag = view?.tag as User
        user = tag
        when(view.id)
        {
            R.id.accept -> UpdateStatus(this.requireContext(),tag.id,StatusProfile.ACCEPTED,viewModel.rowId).execute()
            R.id.decline -> UpdateStatus(this.requireContext(),tag.id,StatusProfile.DECLINED,viewModel.rowId).execute()
        }

    }

}