package me.gulya.topic.conditionalnavigation.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import me.gulya.topic.conditionalnavigation.sample.flow.screens.FlowApproachCartScreen
import me.gulya.topic.conditionalnavigation.sample.straightforward.screens.StraightforwardApproachCartScreen

class RoutingFragment : Fragment(R.layout.fragment_routing) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_straightforward).setOnClickListener {
            DI.router.navigateTo(StraightforwardApproachCartScreen)
        }

        view.findViewById<Button>(R.id.button_flow).setOnClickListener {
            DI.router.navigateTo(FlowApproachCartScreen)
        }
    }

    companion object {
        fun newInstance() = RoutingFragment()
    }
}