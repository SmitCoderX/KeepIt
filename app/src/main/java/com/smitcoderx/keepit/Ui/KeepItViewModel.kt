package com.smitcoderx.keepit.Ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.Repository.KeepItRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KeepItViewModel @Inject constructor(
    private val repostiory: KeepItRepository,
) : ViewModel() {

    fun getAllNotes() = repostiory.getAllNotes()
    fun getAllFolder() = repostiory.getAllFolder()

    // Save Notes
    fun saveNote(title: String, desc: String, priority: String, type: String, folderName: String) =
        viewModelScope.launch {
            val note = Notes(
                null,
                title,
                desc,
                priority,
                folderName,
                type
            )
            repostiory.insertNote(note)
        }

    //    Udpdate Notes
    fun updateNote(
        id: Int,
        title: String,
        desc: String,
        priority: String,
        type: String,
        folderName: String
    ) =
        viewModelScope.launch {
            val notes = Notes(
                id,
                title,
                desc,
                priority,
                folderName,
                type
            )

            repostiory.updateNote(notes)
        }

    //    DeleteNote
    fun deleteNote(note: Notes) = viewModelScope.launch {
        repostiory.deleteNote(note)
    }

    //    Add Folder
    fun insertFolder(folderName: String) = viewModelScope.launch {
        val folder =
            Folder(
                null,
                folderName
            )

        repostiory.insertFolder(folder)
    }

    fun updateFolder(id: Int, folderName: String) = viewModelScope.launch {
        val folder =
            Folder(
                id,
                folderName
            )

        repostiory.updateFolder(folder)
    }

    fun deleteFolder(folder: Folder) = viewModelScope.launch {
        repostiory.deleteFolder(folder)
    }
}