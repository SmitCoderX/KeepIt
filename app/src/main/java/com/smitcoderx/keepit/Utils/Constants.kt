package com.smitcoderx.keepit.Utils

import android.app.Activity
import androidx.core.content.res.ResourcesCompat
import com.smitcoderx.keepit.R
import www.sanju.motiontoast.MotionToast

object Constants {

    const val TAG = "KeepIt"
    const val FOLDER_NAME = "FolderName"
    const val RC_SIGN_IN = 9001
    const val USERS = "users"

    fun getSuccessDarkToast(context: Activity, title: String, desc: String) {
        MotionToast.darkToast(
            context,
            title,
            desc,
            MotionToast.TOAST_SUCCESS,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.SHORT_DURATION,
            ResourcesCompat.getFont(context, R.font.poppins)
        )
    }

    fun getInfoDarkToast(context: Activity, title: String, desc: String) {
        MotionToast.darkToast(
            context,
            title,
            desc,
            MotionToast.TOAST_INFO,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.SHORT_DURATION,
            ResourcesCompat.getFont(context, R.font.poppins)
        )
    }

    fun getErrorDarkToast(context: Activity, title: String, desc: String) {
        MotionToast.darkToast(
            context,
            title,
            desc,
            MotionToast.TOAST_ERROR,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.SHORT_DURATION,
            ResourcesCompat.getFont(context, R.font.poppins)
        )
    }
}