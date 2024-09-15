package com.example.islami_android.callbacks

import com.example.islami_android.ChapterData

interface OnChapterClickListener {
    fun onChapterClick(chapter : ChapterData , chapterPosition  : Int)
}