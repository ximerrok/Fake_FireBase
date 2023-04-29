package com.example.firebase.auth

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebase.R
import com.example.firebase.databinding.FragmentAuthrizationBinding
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.android.inject

class AuthorizationFragment : Fragment(R.layout.fragment_authrization) {

    private val firebaseAuth: FirebaseAuth by inject()
    private val viewBinding: FragmentAuthrizationBinding by viewBinding()

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        viewBinding.confirm.setOnClickListener {
            loginUser()
        }
    }

    fun loginUser(): Unit = with(viewBinding) {
        val emailS: String = email.text.toString().trim()
        val passwordS: String = password.text.toString().trim()
        if (TextUtils.isEmpty(emailS)) {
            Toast.makeText(requireContext(),"Please enter email",Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(passwordS)) {
            Toast.makeText(requireContext(),"Please enter password",Toast.LENGTH_LONG).show()
            return
        }
        firebaseAuth.signInWithEmailAndPassword(emailS,passwordS).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_content,PinCodeFragment(),"PinCode")
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(
                    requireContext(),"Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}