package com.example.bb.services

import com.example.bb.api.ResponseQuote
import com.example.bb.api.api
import retrofit2.http.GET

interface QuoteService {

    @GET("quote/random")
    suspend fun getQuote():ResponseQuote
}


var quoteService: QuoteService = api.create<QuoteService>(QuoteService::class.java)