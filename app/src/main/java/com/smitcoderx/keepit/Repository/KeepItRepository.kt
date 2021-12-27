package com.smitcoderx.keepit.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
/*import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore*/
import com.smitcoderx.keepit.Db.KeepItDatabase
import com.smitcoderx.keepit.Model.Folder
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.Model.User
import com.smitcoderx.keepit.Utils.Constants.TAG
import com.smitcoderx.keepit.Utils.Constants.USERS
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class KeepItRepository @Inject constructor(
    private val db: KeepItDatabase
) {

   /* private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val rootRef = FirebaseFirestore.getInstance()
    private val usersRef: CollectionReference = rootRef.collection(USERS)*/

    suspend fun insertNote(notes: Notes) = db.keepitDao().insert(notes)

    suspend fun updateNote(notes: Notes) = db.keepitDao().update(notes)

    suspend fun deleteNote(notes: Notes) = db.keepitDao().delete(notes)

    suspend fun insertFolder(folder: Folder) = db.keepitDao().insertFolder(folder)

    suspend fun updateFolder(folder: Folder) = db.keepitDao().updateFolder(folder)

    suspend fun deleteFolder(folder: Folder) = db.keepitDao().deleteFolder(folder)


    fun getAllNotes() = db.keepitDao().getAllNotes()
    fun getAllFolder() = db.keepitDao().getAllFolders()


  /*  fun firebaseSignInWithGoogle(googleAuthCredential: AuthCredential): MutableLiveData<User> {
        val authenticatedUserMutableLiveData: MutableLiveData<User> =
            MutableLiveData()

        auth.signInWithCredential(googleAuthCredential).addOnCompleteListener { authTask ->
            if (authTask.isSuccessful) {
                val isNewUser = authTask.result?.additionalUserInfo?.isNewUser
                val firebaseUser: FirebaseUser? = auth.currentUser
                if (firebaseUser != null) {
                    val uid = firebaseUser.uid
                    val name = firebaseUser.displayName
                    val email = firebaseUser.email
                    val photoUrl = firebaseUser.photoUrl
                    val user = User(uid, name.toString(), email.toString(), photoUrl)
                    user.isNew = isNewUser!!
                    authenticatedUserMutableLiveData.value = user
                }
            } else {
                Log.d(TAG, "firebaseSignInWithGoogle: ${authTask.exception!!.message}")
            }
        }
        return authenticatedUserMutableLiveData
    }

    fun createUserIfNotExists(authenticatedUser: User): MutableLiveData<User> {
        val newUserMutableLiveData = MutableLiveData<User>()
        val uidRef = usersRef.document(authenticatedUser.uid)
        uidRef.get().addOnCompleteListener { uidTask ->
            if (uidTask.isSuccessful) {
                val document = uidTask.result
                if (!document.exists()) {
                    uidRef.set(authenticatedUser).addOnCompleteListener { userCreationTask ->
                        if (userCreationTask.isSuccessful) {
                            authenticatedUser.isCreated = true
                            newUserMutableLiveData.value = authenticatedUser
                        } else {
                            Log.d(
                                TAG,
                                "createUserIfNotExists: ${userCreationTask.exception!!.message}"
                            )
                        }
                    }
                } else {
                    newUserMutableLiveData.value = authenticatedUser
                }
            } else {
                Log.d(TAG, "createUserIfNotExists: ${uidTask.exception!!.message}")
            }
        }
        return newUserMutableLiveData
    }*/
}