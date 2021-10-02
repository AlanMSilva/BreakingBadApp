package com.example.bb.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bb.adapters.CharacterListAdapter
import com.example.bb.databinding.FragmentCharacterListBinding
import com.example.bb.models.Characters
import com.example.bb.viewModels.CharacterViewModel

class CharacterListFragment : Fragment() {

    public interface CharacterSelectListener{
        fun onCharacterSelected(characters: Characters)
    }

    private lateinit var characterSelectListener: CharacterSelectListener
    override fun onAttach(context: Context) {
        super.onAttach(context)

        characterSelectListener = try {
            context as CharacterSelectListener
        }catch(error:ClassCastException){
            throw ClassCastException("$context must implement CharacterSelectListener")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharacterListBinding.inflate(inflater,container,false)
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        characterViewModel.characters.observe(viewLifecycleOwner, Observer <MutableList<Characters>>{
                characters ->
            val adapter = CharacterListAdapter(characters)

            adapter.onClickItem = {
                Log.i("edg","Characters ${it.name}")
                characterSelectListener.onCharacterSelected(it)
            }
            binding.recycleCharacterList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recycleCharacterList.adapter = adapter
        })
        return binding.root
    }
}