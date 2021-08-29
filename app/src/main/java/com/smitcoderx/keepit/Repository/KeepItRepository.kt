package com.smitcoderx.keepit.Repository

import com.smitcoderx.keepit.Db.KeepItDatabase
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.Model.Notes
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KeepItRepository @Inject constructor(
    private val db: KeepItDatabase
) {

    suspend fun insertNote(notes: Notes) = db.keepitDao().insert(notes)

    suspend fun updateNote(notes: Notes) = db.keepitDao().update(notes)

    suspend fun deleteNote(notes: Notes) = db.keepitDao().delete(notes)

    suspend fun insertFolder(folder: Folder) = db.keepitDao().insertFolder(folder)

    suspend fun updateFolder(folder: Folder) = db.keepitDao().updateFolder(folder)

    suspend fun deleteFolder(folder: Folder) = db.keepitDao().deleteFolder(folder)


    fun getAllNotes() = db.keepitDao().getAllNotes()
    fun getAllFolder() = db.keepitDao().getAllFolders()

}