package com.smitcoderx.keepit.Ui.Fragments.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smitcoderx.keepit.Adapter.HomeAdapter
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.SetOnClick {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<KeepItViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val homeAdapter = HomeAdapter(this)
        viewModel.getAllNotes().observe(viewLifecycleOwner, { notesList ->
            if (notesList.isNullOrEmpty()) {
                binding.rvHome.visibility = View.INVISIBLE
                binding.tvExtra.visibility = View.VISIBLE
            } else {
                homeAdapter.differ.submitList(notesList)
                binding.rvHome.visibility = View.VISIBLE
                binding.tvExtra.visibility = View.INVISIBLE
            }
        })

        binding.fabNote.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToSingleFragment(
                    null
                )
            )
        }

        binding.rvHome.apply {
            setHasFixedSize(true)
            adapter = homeAdapter
        }

    }

    override fun onClick(notes: Notes) {
        val action = HomeFragmentDirections.actionHomeFragmentToSingleFragment(notes)
        findNavController().navigate(action)
    }


}