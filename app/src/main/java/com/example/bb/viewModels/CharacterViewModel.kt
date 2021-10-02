package com.example.bb.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bb.models.Characters
import com.example.bb.services.characterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel: ViewModel() {
    private var _characters = MutableLiveData<MutableList<Characters>>()
    val characters: LiveData<MutableList<Characters>>
        get() = _characters

    init {
        viewModelScope.launch {
            _characters.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<Characters>{
        return withContext(Dispatchers.IO){
            val characters: MutableList<Characters> = characterService.getCharacters()
            characters
        }
    }
}