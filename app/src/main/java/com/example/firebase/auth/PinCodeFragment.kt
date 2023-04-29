package com.example.firebase.auth

import android.widget.Button
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.firebase.R
import com.example.firebase.databinding.MainPincodeBinding

class PinCodeFragment : Fragment(R.layout.main_pincode) {
    private val viewBinding: MainPincodeBinding by viewBinding()
    private val numbers = arrayOfNulls<Button>(10)
    private val buttonIds = intArrayOf(
        R.id.b0,R.id.b1,R.id.b2,
        R.id.b3,R.id.b4,R.id.b5,
        R.id.b6,R.id.b7,R.id.b8,
        R.id.b9
    )

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        for (i in buttonIds.indices) {
            numbers[i] = viewBinding.root.findViewById(buttonIds[i])
            numbers[i]?.setOnClickListener {
                val changer = viewBinding.pincode.text.toString() + i
                viewBinding.pincode.text = changer
            }
        }
        viewBinding.backspace.setOnClickListener {
            val current = viewBinding.pincode.text.toString()
            if (current.isNotEmpty()) {
                val changer = current.substring(0,current.length - 1)
                viewBinding.pincode.text = changer
            }
        }
        viewBinding.next.setOnClickListener {

        }
    }
}