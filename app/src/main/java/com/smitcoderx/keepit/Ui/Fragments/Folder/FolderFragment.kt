package com.smitcoderx.keepit.Ui.Fragments.Folder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.smitcoderx.keepit.Adapter.FolderAdapter
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.databinding.FragmentFolderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FolderFragment : Fragment(R.layout.fragment_folder) {

    private lateinit var binding: FragmentFolderBinding
    private lateinit var folderAdapter: FolderAdapter
    private val viewModel by viewModels<KeepItViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFolderBinding.bind(view)

        folderAdapter = FolderAdapter()

        viewModel.getAllFolder().observe(viewLifecycleOwner, { folderList ->
            if (folderList.isNullOrEmpty()) {
                binding.rvFolder.visibility = View.INVISIBLE
                binding.tvExtra.visibility = View.VISIBLE
            } else {
                folderAdapter.differ.submitList(folderList)
                binding.rvFolder.visibility = View.VISIBLE
                binding.tvExtra.visibility = View.INVISIBLE
            }
        })

        binding.fabFolder.setOnClickListener {
            viewModel.insertFolder("Check1")
        }

        binding.rvFolder.apply {
            setHasFixedSize(true)
            adapter = folderAdapter
        }
    }
}