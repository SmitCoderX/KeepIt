package com.smitcoderx.keepit.Ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.smitcoderx.keepit.Adapter.SinglePagerAdapter
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.Fragments.Folder.FolderFragment
import com.smitcoderx.keepit.Ui.Fragments.Home.HomeFragment
import com.smitcoderx.keepit.databinding.FragmentSingleViewPagerBinding

class SingleViewPagerFragment : Fragment(R.layout.fragment_single_view_pager) {

    private lateinit var binding: FragmentSingleViewPagerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleViewPagerBinding.bind(view)


        val fragmentList = arrayListOf(
            HomeFragment(),
            FolderFragment()
        )

        val adapter = SinglePagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.home)
                1 -> tab.text = getString(R.string.folder)
            }
        }.attach()
    }

}