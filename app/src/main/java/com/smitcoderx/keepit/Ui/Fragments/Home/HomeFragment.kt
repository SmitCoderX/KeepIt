package com.smitcoderx.keepit.Ui.Fragments.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
    }

}