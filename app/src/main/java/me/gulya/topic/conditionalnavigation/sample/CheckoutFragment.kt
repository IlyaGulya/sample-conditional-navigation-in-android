package me.gulya.topic.conditionalnavigation.sample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class CheckoutFragment : Fragment(R.layout.fragment_checkout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!DI.isUserAuthorized) {
            Toast.makeText(context, "Checkout needs user to authorize!", Toast.LENGTH_SHORT).show()
        }
    }
}

