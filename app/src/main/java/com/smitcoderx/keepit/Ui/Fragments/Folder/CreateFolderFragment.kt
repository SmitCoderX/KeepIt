package com.smitcoderx.keepit.Ui.Fragments.Folder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.Utils.Constants.FOLDER_NAME
import com.smitcoderx.keepit.databinding.FragmentCreateFolderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFolderFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCreateFolderBinding
    private val viewModel by viewModels<KeepItViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_folder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateFolderBinding.bind(view)

        binding.ivCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnDone.setOnClickListener {
            val folderName = binding.etFolderName.text.toString()
            if (folderName.isEmpty()) {
                binding.etFolderName.error = "Folder Name Cannot be Empty!!"
            } else {
                viewModel.insertFolder(folderName)
                findNavController().previousBackStackEntry?.savedStateHandle?.set(
                    FOLDER_NAME,
                    folderName
                )
                findNavController().popBackStack()
            }
        }
    }
}