package com.example.islami_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.inflate
import com.example.islami_android.ChapterData
import com.example.islami_android.R
import com.example.islami_android.callbacks.OnChapterClickListener

class ChaptersAdapter(val chapters : List<ChapterData>) : Adapter<ChaptersAdapter.ChapterViewHolder>() {
    var onChapterClickListener: OnChapterClickListener?= null
    class ChapterViewHolder(val itemChapterView : View) : ViewHolder(itemChapterView){
        val chapterNameTextView : TextView = itemChapterView.findViewById(R.id.chapter_name)
        val chapterPositionTextView : TextView = itemChapterView.findViewById(R.id.chapter_position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_chapter_name , parent , false)
        return ChapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val item = chapters.get(position)
        holder.chapterNameTextView.text = item.name
        holder.chapterPositionTextView.text = "${item.position}"
        holder.itemChapterView.setOnClickListener{
            onChapterClickListener?.onChapterClick(item , position)
        }
    }
}