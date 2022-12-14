package com.barab.shopyellow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barab.shopyellow.databinding.JacketsListItemBinding
import com.barab.shopyellow.room.JacketsData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class JacketsListAdapter : RecyclerView.Adapter<JacketsListAdapter.ViewHolder>(){
    var items: List<JacketsData> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    private var itemClick: (JacketsData) -> Unit = {}
    fun itemClick(listener: (JacketsData) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jackets_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.binding.jackets = items[position]
        holder.itemView.setOnClickListener{
            itemClick(items[position])
    }

        }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var binding = JacketsListItemBinding.bind(view)
    }

}







