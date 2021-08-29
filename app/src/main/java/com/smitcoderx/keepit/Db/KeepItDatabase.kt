package com.smitcoderx.keepit.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.Model.Notes

@Database(
    entities = [Notes::class, Folder::class],
    version = 2
)

abstract class KeepItDatabase : RoomDatabase() {

    abstract fun keepitDao(): KeepItDao
}