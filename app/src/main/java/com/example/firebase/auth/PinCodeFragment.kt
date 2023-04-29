package com.example.firebase.auth

import android.widget.ImageButton
import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebase.R
import com.example.firebase.databinding.MainPincodeBinding

class PinCodeFragment : Fragment(R.layout.main_pincode) {
    private val viewBinding: MainPincodeBinding by viewBinding()
    private var backspace: ImageButton? = null
    private val numbers = arrayOfNulls<Button>(10)
    private val button_ids = intArrayOf(
        R.id.b0,R.id.b1,R.id.b2,
        R.id.b3,R.id.b4,R.id.b5,
        R.id.b6,R.id.b7,R.id.b8,
        R.id.b9
    )
    private var pinCode: TextView? = null
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        for (i in button_ids.indices) {
            numbers[i] = viewBinding.root.findViewById(button_ids[i])
            numbers[i]?.setOnClickListener {
                val changer = pinCode?.text.toString() +
                        i
                pinCode?.text = changer
            }
        }
        backspace?.setOnClickListener {
            val current = pinCode?.text.toString()
            if (current.isNotEmpty()) {
                val changer = current.substring(0,current.length - 1)
                pinCode?.text = changer
            }
        }
    }
}