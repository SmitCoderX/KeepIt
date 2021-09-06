package com.smitcoderx.keepit.Db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.Model.Notes

@Dao
interface KeepItDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: Notes)

    @Update
    suspend fun update(notes: Notes)

    @Delete
    suspend fun delete(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFolder(folder: Folder)

    @Update
    suspend fun updateFolder(folder: Folder)

    @Delete
    suspend fun deleteFolder(folder: Folder)

    @Query("SELECT * FROM foldername")
    fun getAllFolders(): LiveData<List<Folder>>
}