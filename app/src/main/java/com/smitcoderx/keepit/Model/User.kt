package com.smitcoderx.keepit.Model

import android.net.Uri
import android.os.Parcelable
import com.google.firebase.firestore.Exclude
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val uid: String,
    val name: String,
    @SuppressWarnings("WeakerAccess")
    val email: String,
    val photoUrl: Uri?,
    @Exclude
    var isAuthenticated: Boolean? = false,
    @Exclude
    var isNew: Boolean? = false,
    @Exclude
    var isCreated: Boolean? = false
) : Parcelable