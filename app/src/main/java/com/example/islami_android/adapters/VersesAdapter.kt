package com.example.islami_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami_android.R

class VersesAdapter(val verses : List<String>?) : Adapter<VersesAdapter.VersesViewHolder>(){
    class VersesViewHolder(val itemVerseView : View) : ViewHolder(itemVerseView){
        val content : TextView = itemVerseView.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_verse, parent , false)
        return VersesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return verses?.size ?: 0
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        val item = verses?.get(position)!!
        holder.content.text = item

    }
}