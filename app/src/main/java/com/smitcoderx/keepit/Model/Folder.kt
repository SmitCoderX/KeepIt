package com.smitcoderx.keepit.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "FolderName"
)

@Parcelize
data class Folder(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val folderName: String?
) : Parcelable
