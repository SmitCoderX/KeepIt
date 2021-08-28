package com.smitcoderx.keepit.Ui.Fragments.Folder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.databinding.FragmentFolderBinding

class FolderFragment : Fragment(R.layout.fragment_folder) {

    private lateinit var binding: FragmentFolderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFolderBinding.bind(view)
    }

}