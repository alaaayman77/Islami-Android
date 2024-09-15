package com.example.islami_android.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_android.Constants
import com.example.islami_android.R
import com.example.islami_android.adapters.VersesAdapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var versesRecyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var chapterName: String
    lateinit var titleTextView: TextView
    lateinit var backImageView: ImageView
    var chapterPosition : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_details)
        initParams()
        initViews()
        readChapterFromFile()
    }
    fun initParams(){
        chapterName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME) ?: ""
        chapterPosition = intent.getIntExtra(Constants.EXTRA_CHAPTER_POSITION, -1)
    }
    fun initViews(){
        versesRecyclerView = findViewById(R.id.verses_recycler_view)
        titleTextView = findViewById(R.id.title_toolbar)
        titleTextView.text = chapterName
        backImageView = findViewById(R.id.ic_back)
        backImageView.setOnClickListener {
            finish()
        }
//

    }
    fun readChapterFromFile(){
        val allFilesContent =assets.open("${chapterPosition}.txt")
            .bufferedReader()
            .readText()
        val verses = allFilesContent.split("\n")
        adapter = VersesAdapter(verses)
        versesRecyclerView.adapter = adapter

    }
}