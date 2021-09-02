package com.smitcoderx.keepit.Ui.Fragments.Single

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.databinding.FragmentSingleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleFragment : Fragment(R.layout.fragment_single) {

    private lateinit var binding: FragmentSingleBinding
    private val viewModel by viewModels<KeepItViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleBinding.bind(view)

        binding.fabSave.setOnClickListener {
            viewModel.saveNote(
                binding.titleET.text.toString(),
                binding.noteET.text.toString(),
                "Top",
                "Empty",
                "Empty"
            )
            findNavController().popBackStack()
        }

    }

}