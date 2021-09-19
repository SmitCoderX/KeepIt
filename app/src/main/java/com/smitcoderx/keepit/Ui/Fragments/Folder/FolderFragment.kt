package com.smitcoderx.keepit.Ui.Fragments.Folder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.smitcoderx.keepit.Adapter.FolderAdapter
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.Utils.Constants.FOLDER_NAME
import com.smitcoderx.keepit.databinding.FragmentFolderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FolderFragment : Fragment(R.layout.fragment_folder), FolderAdapter.SetOnFolderClick {

    private lateinit var binding: FragmentFolderBinding
    private val viewModel by viewModels<KeepItViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFolderBinding.bind(view)

        val folderAdapter = FolderAdapter(this)



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

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(FOLDER_NAME)
            ?.observe(
                viewLifecycleOwner, {
                    Snackbar.make(binding.rootFolder, "$it Created", Snackbar.LENGTH_SHORT).show()
                }
            )

        binding.fabFolder.setOnClickListener {
            findNavController().navigate(FolderFragmentDirections.actionFolderFragmentToCreateFolderFragment())
        }

        binding.rvFolder.apply {
            setHasFixedSize(true)
            adapter = folderAdapter
        }
    }

    override fun setOnFolderClick(folder: Folder) {
        Snackbar.make(binding.rootFolder, folder.folderName.toString(), Snackbar.LENGTH_SHORT)
            .show()
    }
}