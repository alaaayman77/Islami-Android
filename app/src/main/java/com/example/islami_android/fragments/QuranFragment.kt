package com.example.islami_android.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_android.ChapterData
import com.example.islami_android.activities.ChapterDetailsActivity
import com.example.islami_android.Constants
import com.example.islami_android.R
import com.example.islami_android.adapters.ChaptersAdapter
import com.example.islami_android.callbacks.OnChapterClickListener

class QuranFragment : Fragment() {
    lateinit var chaptersRecyclerView: RecyclerView
    lateinit var adapter: ChaptersAdapter
    lateinit var switchModeButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

    }
    @SuppressLint("SuspiciousIndentation")
    fun initViews(view: View){
        chaptersRecyclerView = view.findViewById(R.id.chapters_recycler_view)
        val chapters = Constants.chapters
        val chaptersDataList: MutableList<ChapterData> = mutableListOf<ChapterData>()
            chapters.forEachIndexed { index , name ->
            chaptersDataList.add(ChapterData(name,index+1))
        }
        adapter = ChaptersAdapter(chaptersDataList)
        adapter.onChapterClickListener = object : OnChapterClickListener{
            override fun onChapterClick(chapter: ChapterData, chapterPosition: Int) {
                //context , requireContext
                //activity , requireActivity
                val intent = Intent(requireContext() , ChapterDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_CHAPTER_NAME , chapter.name)
                intent.putExtra(Constants.EXTRA_CHAPTER_POSITION , chapter.position)
                startActivity(intent)
            }

        }

        chaptersRecyclerView.adapter = adapter
        switchModeButton = view.findViewById(R.id.switch_mode_button)
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            switchModeButton.text= "Light Mode"
        }
        else{
            switchModeButton.text= "Dark Mode"
        }
        switchModeButton.setOnClickListener{
            if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchModeButton.text= "Dark Mode"
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchModeButton.text= "Light Mode"
            }
        }
    }
}
