package com.example.bb.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.bb.R
import com.example.bb.databinding.ActivityDetailBinding
import com.example.bb.models.Characters

class DetailActivity : AppCompatActivity() {
    companion object {
        const val CHARACTER_KEY = "character_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val bundle: Bundle? = intent.extras

        if (bundle != null){
            val BBcharacter = bundle.getParcelable<Characters>(CHARACTER_KEY)
            Glide
                .with(binding.root)
                .load(BBcharacter?.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageViewDetail)

            //binding.imageViewDetail.setImageResource(img)
            binding.nameDetail.text = BBcharacter?.name
            binding.nicknameDetail.text = BBcharacter?.nickname
            binding.statusDetail.text = BBcharacter?.status
            binding.birthdayDetail.text = BBcharacter?.birthday
            //binding.ocupationDetail.arrar = BBcharacter?.ocupation
            binding.actorNameDetail.text = BBcharacter?.portrayed
        }
    }
}