package com.smitcoderx.keepit.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity(
    tableName = "notes"
)

@Parcelize
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String?,
    val description: String?,
    val priority: String?,
    val folderName: String?,
    val date: String = getDateAndTime()
) : Parcelable {
    companion object {
        private fun getDateAndTime(): String {
            val currentTime: Date = Calendar.getInstance().time
            return currentTime.toString()
        }
    }
}