package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemsList: List<String>) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {


        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(
            R.layout.list_item,
            parent,
            false
        )

        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int = itemsList.size
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {

        val value = itemsList[position]

        holder.textView.text = value
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textView = itemView.findViewById<TextView>(R.id.textVeiw)

}