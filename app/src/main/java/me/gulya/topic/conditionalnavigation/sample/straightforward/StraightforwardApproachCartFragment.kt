package me.gulya.topic.conditionalnavigation.sample.straightforward

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import me.gulya.topic.conditionalnavigation.sample.CheckoutScreen
import me.gulya.topic.conditionalnavigation.sample.DI
import me.gulya.topic.conditionalnavigation.sample.R
import me.gulya.topic.conditionalnavigation.sample.straightforward.screens.StraightforwardApproachAuthScreen

class StraightforwardApproachCartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(StraightforwardApproachAuthFragment.REQUEST_KEY) { requestKey, bundle ->
            val result = StraightforwardApproachAuthFragment.extractResult(bundle)
            if (result == AuthResult.SUCCESSFUL) {
                // Required because fragment result is executed during fragment transaction and navigation causes new transaction which is not allowed during pending transaction.
                view.post {
                    DI.router.navigateTo(CheckoutScreen)
                }
            } else {
                Toast.makeText(context, "You need to authorize to proceed!", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<Button>(R.id.button_checkout)
            .setOnClickListener {
                if (DI.isUserAuthorized) {
                    DI.router.navigateTo(CheckoutScreen)
                } else {
                    DI.router.navigateTo(StraightforwardApproachAuthScreen)
                }
            }
    }
}