package com.example.assignmentshaadi.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentshaadi.room.entities.User
import com.example.assignmentshaadi.R
import kotlinx.android.synthetic.main.row_accepted_profiles.view.*

class AcceptedProfilesRecyclerAdapter(val context : Context?) : RecyclerView.Adapter<AcceptedProfilesRecyclerAdapter.ViewHolder>() {

    private var data : MutableList<User> = arrayListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_accepted_profiles,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var name = String.format("%s. %s %s",data.get(position).title,data.get(position).first,data.get(position).last)
        holder.itemView.name.setText(name)
        holder.itemView.email.setText(data.get(position).email)

        context?.let {
            Glide.with(it)
                .load(data.get(position).thumbnail)
                .centerCrop()
                .into(holder.itemView.avatar)
        };

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data : MutableList<User>):Unit
    {
        this.data = data
        notifyDataSetChanged()
    }

    fun getData():MutableList<User>{
        return data
    }

}