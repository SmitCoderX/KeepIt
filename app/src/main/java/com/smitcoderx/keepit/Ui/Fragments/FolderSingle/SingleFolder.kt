package com.smitcoderx.keepit.Ui.Fragments.FolderSingle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.databinding.FragmentSingleFolderBinding

class SingleFolder : Fragment(R.layout.fragment_single_folder) {

    private lateinit var binding: FragmentSingleFolderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleFolderBinding.bind(view)



    }

}