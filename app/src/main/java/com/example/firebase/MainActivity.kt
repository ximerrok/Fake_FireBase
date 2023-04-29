package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.auth.AuthorizationFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_content,AuthorizationFragment(),"AuthorizationFragment")
            .addToBackStack(null)
            .commit()
    }

//    fun createUserAccount() {
//        val createEmail: String = email.getText().toString().trim()
//        val createPassword: String = password.getText().toString().trim()
//        if (TextUtils.isEmpty(createEmail)) {
//            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show()
//            return
//        }
//        if (TextUtils.isEmpty(createPassword)) {
//            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show()
//            return
//        }
//        firebaseAuth.createUserWithEmailAndPassword(createEmail,createPassword)
//            .addOnCompleteListener(this,OnCompleteListener<AuthResult?> { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    val user: FirebaseUser = firebaseAuth.getCurrentUser()
//                    Toast.makeText(
//                        this@MainActivity,"Welcome!",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                } else {
//                    Toast.makeText(
//                        this@MainActivity,"Authentication failed.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            })
//    }

}