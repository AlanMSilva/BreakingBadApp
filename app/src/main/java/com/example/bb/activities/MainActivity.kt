package com.example.bb.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.bb.R
import com.example.bb.adapters.ViewPagerAdapter
import com.example.bb.fragments.CharacterListFragment
import com.example.bb.models.Characters
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var movieProfileFragment: CharacterListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="CHARACTERS"
                }
                1->{
                    tab.text="PHRASE"
                }
                2->{
                    tab.text="SETTINGS"
                }
            }
        }.attach()
    }
     fun onCharacterSelected(characters: Characters) {
        Log.i("edg","Movie Load On MainActivity: ${characters.name}")
        val intent = Intent (this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.CHARACTER_KEY,characters)
        }
    }

}