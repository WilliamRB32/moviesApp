package com.example.taller2.adapters

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taller2.InterfaceFavorites
import com.example.taller2.classes.MovieG
import com.example.taller2.fragments.FragmentFavorites
import com.example.taller2.fragments.FragmentPopular
import com.example.taller2.viewModel.MoviesViewModel


class TabAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentPopular()
            1 -> FragmentFavorites()
            else -> FragmentPopular()
        }
    }

}