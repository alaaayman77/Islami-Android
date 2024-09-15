package com.example.islami_android.callbacks

import com.example.islami_android.Quote

interface OnQuoteClickListener {
    fun onQuoteClick(quote : Quote , position: Int)
}