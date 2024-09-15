package com.example.islami_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami_android.Quote
import com.example.islami_android.R
import com.example.islami_android.callbacks.OnQuoteClickListener

class QuotesAdapter(val quotesList: List<Quote>) : Adapter<QuotesAdapter.QuotesViewHolder>(){
    var onQuoteClickListener: OnQuoteClickListener?=null
    class QuotesViewHolder(private val itemQuoteView : View) : ViewHolder(itemQuoteView){
        val quote : TextView = itemQuoteView.findViewById(R.id.content)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.item_verse , parent , false)
        return QuotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val item = quotesList.get(position)
        holder.quote.text = item.title
        holder.quote.setOnClickListener{
            onQuoteClickListener?.onQuoteClick(item,position)
        }
    }
}