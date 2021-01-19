package me.gulya.topic.conditionalnavigation.sample.flow

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import me.gulya.topic.conditionalnavigation.sample.DI
import me.gulya.topic.conditionalnavigation.sample.R
import me.gulya.topic.conditionalnavigation.sample.flow.screens.CheckoutFlow

class FlowApproachCartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_checkout)
            .setOnClickListener {
                DI.router.navigateTo(CheckoutFlow(DI.router), clearContainer = false)
            }
    }

    companion object {
        fun newInstance() = FlowApproachCartFragment()
    }
}