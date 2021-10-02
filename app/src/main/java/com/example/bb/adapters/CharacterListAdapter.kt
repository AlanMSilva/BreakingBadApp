package com.example.bb.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bb.R
import com.example.bb.databinding.CharacterItemBinding
import com.example.bb.models.Characters

class CharacterListAdapter (private val characterList: List<Characters>): RecyclerView.Adapter<CharacterListAdapter.ViewHolder>(){

    lateinit var onClickItem: (Characters)-> Unit

    inner class ViewHolder (private val binding: CharacterItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(characters:Characters){
            Glide
                .with(binding.root)
                .load(characters.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)

            binding.nameTextView.text = characters.name
            binding.birthdayTextView.text = characters.birthday
            binding.nicknameTextView.text = characters.nickname
            binding.statusTextView.text = characters.status
            binding.root.setOnClickListener(){
                if(::onClickItem.isInitialized)
                    onClickItem(characters)
                else
                    Log.i("edg","onCharactersClick event is not initialized")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }
}