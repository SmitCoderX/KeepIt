package com.smitcoderx.keepit.Ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.google.firebase.auth.AuthCredential
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.Model.User
import com.smitcoderx.keepit.Repository.KeepItRepository
import com.smitcoderx.keepit.Utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KeepItViewModel @Inject constructor(
    private val repostiory: KeepItRepository,
) : ViewModel() {

    fun getAllNotes() = repostiory.getAllNotes()
    fun getAllFolder() = repostiory.getAllFolder()
    private var _authenticateUserLiveData: MutableLiveData<User> = MutableLiveData()
    val authenticatedUserLiveData: LiveData<User> get() = _authenticateUserLiveData
    var createdUserLiveData = MutableLiveData<User>()

    // Save Notes
    fun saveNote(
        title: String,
        desc: String,
        priority: String,
        label: String,
        folderName: String
    ) =
        viewModelScope.launch {
            val note = Notes(
                null,
                title,
                desc,
                priority,
                folderName,
                label
            )
            repostiory.insertNote(note)
        }

    //    Udpdate Notes
    fun updateNote(
        id: Int,
        title: String,
        desc: String,
        priority: String,
        label: String,
        folderName: String
    ) =
        viewModelScope.launch {
            val notes = Notes(
                id,
                title,
                desc,
                priority,
                folderName,
                label
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

  /*  fun signInWithGoogle(googleAuthCredential: AuthCredential) {
        _authenticateUserLiveData = repostiory.firebaseSignInWithGoogle(googleAuthCredential)
    }

    fun createUser(user: User) {
        createdUserLiveData = repostiory.createUserIfNotExists(user)
    }*/
}