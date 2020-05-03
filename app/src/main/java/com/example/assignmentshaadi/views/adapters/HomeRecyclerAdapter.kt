package com.example.assignmentshaadi.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentshaadi.R
import com.example.assignmentshaadi.room.entities.User
import kotlinx.android.synthetic.main.row_home.view.*

class HomeRecyclerAdapter(val context : Context?,val clickListener: View.OnClickListener) : RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {

    private var data : MutableList<User> = arrayListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_home,parent,false)
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

        holder.itemView.accept.tag = data.get(position)
        holder.itemView.accept.setOnClickListener(clickListener)

        holder.itemView.decline.tag = data.get(position)
        holder.itemView.decline.setOnClickListener(clickListener)

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

    fun remove(user : User):Unit{

        data.remove(user)
        notifyDataSetChanged()
    }
}