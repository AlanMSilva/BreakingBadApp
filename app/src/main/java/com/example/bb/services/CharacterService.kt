package com.example.bb.services

import com.example.bb.api.Response
import com.example.bb.api.api
import retrofit2.http.GET

interface CharacterService {

    @GET("characters")
    suspend fun getCharacters():Response
}


var characterService: CharacterService = api.create<CharacterService>(CharacterService::class.java)