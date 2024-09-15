package com.example.islami_android.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_android.Constants
import com.example.islami_android.Quote
import com.example.islami_android.R
import com.example.islami_android.activities.QuoteDetailsActivity
import com.example.islami_android.adapters.QuotesAdapter
import com.example.islami_android.adapters.VersesAdapter
import com.example.islami_android.callbacks.OnQuoteClickListener

class HadethFragment : Fragment() {
    lateinit var hadethRecyclerView: RecyclerView
    lateinit var adapter : QuotesAdapter

    lateinit var quotesMutableList:MutableList<Quote>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }
    fun initViews(view : View){
        hadethRecyclerView = view.findViewById(R.id.hadeth_recycler_view)
        val allFileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use{
            it.readText()
        }
        val hadethList = allFileContent.split("#")
        quotesMutableList= mutableListOf()
        hadethList.forEach{hadeth ->
            val hadethSeperated= hadeth.trim().split("\n")
            val title = hadethSeperated.get(0)
            val description: String = hadethSeperated.subList(1,hadethSeperated.size).joinToString()
            val quote = Quote(title,description)
            quotesMutableList.add(quote)
        }
        adapter = QuotesAdapter(quotesMutableList)
        hadethRecyclerView.adapter = adapter
        adapter.onQuoteClickListener = object : OnQuoteClickListener{
            override fun onQuoteClick(quote: Quote, position: Int) {
                val intent= Intent(requireActivity(),QuoteDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_QUOTE_TITLE, quote.title)
                intent.putExtra(Constants.EXTRA_QUOTE_DESCRIPTION, quote.description)
                startActivity(intent)

            }

        }
    }
}
