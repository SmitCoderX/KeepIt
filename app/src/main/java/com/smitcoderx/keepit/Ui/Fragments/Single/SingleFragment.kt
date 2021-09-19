package com.smitcoderx.keepit.Ui.Fragments.Single

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.databinding.FragmentSingleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleFragment : Fragment(R.layout.fragment_single) {

    private lateinit var binding: FragmentSingleBinding
    private val viewModel by viewModels<KeepItViewModel>()
    private val args by navArgs<SingleFragmentArgs>()
    private lateinit var data: Notes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleBinding.bind(view)

        data = args.notes!!
        if (data.id != null) {
            binding.apply {
                titleET.setText(data.title)
                noteET.setText(data.description)
            }
        }

    }

    override fun onPause() {
        super.onPause()
        if (binding.titleET.text!!.isNotEmpty() && binding.noteET.text!!.isNotEmpty()) {
            if (data.id != null) {
                viewModel.updateNote(
                    data.id!!,
                    binding.titleET.text.toString(),
                    binding.noteET.text.toString(),
                    "Top",
                    "Empty",
                    "Empty"
                )
            } else {
                viewModel.saveNote(
                    binding.titleET.text.toString(),
                    binding.noteET.text.toString(),
                    "Top",
                    "Empty",
                    "Empty"
                )
            }
        }
    }
}