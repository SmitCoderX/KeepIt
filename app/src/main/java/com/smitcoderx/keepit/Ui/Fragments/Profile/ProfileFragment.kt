package com.smitcoderx.keepit.Ui.Fragments.Profile

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.fragment.app.Fragment
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.ivDrop.setOnClickListener {
            if (binding.expandableView.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(binding.cardView, AutoTransition())
                binding.expandableView.visibility = View.VISIBLE
                binding.ivDrop.rotationX = 180f
            } else {
                TransitionManager.beginDelayedTransition(binding.cardView, AutoTransition())
                binding.expandableView.visibility = View.GONE
                binding.ivDrop.rotationX = 0f
            }
        }
    }
}