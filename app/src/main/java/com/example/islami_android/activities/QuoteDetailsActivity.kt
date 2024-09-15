package com.example.islami_android.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_android.Constants
import com.example.islami_android.R
import com.example.islami_android.adapters.VersesAdapter

class QuoteDetailsActivity : AppCompatActivity() {
    var title : String?=""
    var description : String?=""
    lateinit var quoteDetailsRecyclerView : RecyclerView
    lateinit var adapter:VersesAdapter
    lateinit var backImage:ImageView
    lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)
        initParams()
        initViews()

    }
    private fun initParams(){
        title=intent.getStringExtra(Constants.EXTRA_QUOTE_TITLE)
        description=intent.getStringExtra(Constants.EXTRA_QUOTE_DESCRIPTION)
    }
    private fun initViews(){
        quoteDetailsRecyclerView = findViewById(R.id.quotes_description_recycler_view)
        adapter= VersesAdapter(description?.split("\n"))
        quoteDetailsRecyclerView.adapter=adapter
        backImage= findViewById(R.id.ic_back)
        backImage.setOnClickListener{
            finish()
        }
        titleTextView=findViewById(R.id.toolbar_title)
        titleTextView.text = title
        
    }
}