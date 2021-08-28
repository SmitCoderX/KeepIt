package com.smitcoderx.keepit.Ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.smitcoderx.keepit.Repository.KeepItRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KeepItViewModel @Inject constructor(
    private val repostiory: KeepItRepository,
) : ViewModel() {


}