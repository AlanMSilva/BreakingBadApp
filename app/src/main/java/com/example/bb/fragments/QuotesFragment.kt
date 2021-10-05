package com.example.bb.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bb.R
import com.example.bb.databinding.FragmentQuotesBinding
import com.example.bb.models.Quotes
import com.example.bb.viewModels.QuotesViewModel

class QuotesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_quotes, container, false)
        val binding = FragmentQuotesBinding.inflate(inflater,container, false)
        val quotesViewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)

        quotesViewModel.quotes.observe(viewLifecycleOwner, Observer<MutableList<Quotes>>{
                quotes ->

            binding.randomQuotes.text = quotes[0].quote
            binding.nameQuotes.text = quotes[0].author
        })
        return binding.root
    }
    override fun onPause() {
        super.onPause()
        val quoteViewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)
        quoteViewModel.cambiar()
    }
}