package com.example.bb.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bb.models.Quotes
import com.example.bb.services.quoteService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel: ViewModel() {
    private var _quotes = MutableLiveData<MutableList<Quotes>>()
    val quotes: LiveData<MutableList<Quotes>>
        get() = _quotes

    init {
        viewModelScope.launch {
            _quotes.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<Quotes> {
        return withContext(Dispatchers.IO) {
            val quotes: MutableList<Quotes> = quoteService.getQuote()
            quotes
        }
    }
    fun cambiar() {
        viewModelScope.launch {
            _quotes.value = fetch()
        }
    }
}