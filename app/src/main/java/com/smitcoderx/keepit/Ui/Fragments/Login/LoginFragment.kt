package com.smitcoderx.keepit.Ui.Fragments.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
/*import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider*/
import com.smitcoderx.keepit.Model.User
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.KeepItViewModel
import com.smitcoderx.keepit.Utils.Constants.RC_SIGN_IN
import com.smitcoderx.keepit.Utils.Constants.TAG
import com.smitcoderx.keepit.Utils.Constants.getSuccessDarkToast
import com.smitcoderx.keepit.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    //    lateinit var googleSignInClient: GoogleSignInClient
    private val viewModel by viewModels<KeepItViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

//        initGoogleSignInClient()

        /*binding.btnLogin.setOnClickListener {
            signInUsingGoogle()
        }*/
    }


    /* private fun initGoogleSignInClient() {
         val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
             .requestIdToken(getString(R.string.client_id))
             .requestEmail()
             .build()

         googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
     }

     private fun signInUsingGoogle() {
         val signInGoogleIntent = googleSignInClient.signInIntent
         startActivityForResult(signInGoogleIntent, RC_SIGN_IN)
     }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)

         if (requestCode == RC_SIGN_IN) {
             val task = GoogleSignIn.getSignedInAccountFromIntent(data)
             try {
                 val account = task.getResult(ApiException::class.java)
                 if (account != null) {
                     getGoogleAuthCredential(account)
                 }
             } catch (e: ApiException) {
                 e.printStackTrace()
                 Log.d(TAG, "Google Sign in Failed: ${e.message}")
             }
         }
     }


     private fun getGoogleAuthCredential(account: GoogleSignInAccount) {
         val googleTokenId = account.idToken
         val googleAuthCredential = GoogleAuthProvider.getCredential(googleTokenId, null)
         signInWithGoogleAuthCredential(googleAuthCredential)
     }

     private fun signInWithGoogleAuthCredential(googleAuthCredential: AuthCredential) {
         viewModel.signInWithGoogle(googleAuthCredential)
         viewModel.authenticatedUserLiveData.observe(requireActivity(), {
             if (it.isNew == true) {
                 createNewUser(it)
             } else {
                 goToHomeFragment()
             }
         })
     }

     private fun createNewUser(user: User) {
         viewModel.createUser(user)
         viewModel.createdUserLiveData.observe(requireActivity(), {
             if (it.isCreated == true) {
                 getSuccessDarkToast(
                     requireActivity(),
                     "Hi ${it.name}",
                     "Your Account is Successfully Created"
                 )
                 goToHomeFragment()
             }
         })
     }*/

    private fun goToHomeFragment() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }
}