package com.agh.projectdatabase1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: List<phone>): RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder>() {


    class ListAdapterViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {
        val textph : TextView = itemView.findViewById(R.id.txtshowphone)
        val textn : TextView = itemView.findViewById(R.id.txtshowname)
        val textge : TextView = itemView.findViewById(R.id.txtshowgender)

    }

private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {

        context=parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ListAdapterViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        holder.textph.text =  list[position].ph
        holder.textn.text =  list[position].name
        holder.textge.text =  list[position].jen

    }

    override fun getItemCount(): Int {
        return list.size
    }

}
























