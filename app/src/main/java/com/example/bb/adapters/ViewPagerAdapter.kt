package com.example.bb.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bb.fragments.CharacterListFragment
import com.example.bb.fragments.QuotesFragment
import com.example.bb.fragments.ThirdFragment
import com.example.bb.models.Quotes

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0->{
                CharacterListFragment()
            }
            1->{
                QuotesFragment()
            }
            2->{
                ThirdFragment()
            }
            else->{
                Fragment()
            }

        }
    }
}