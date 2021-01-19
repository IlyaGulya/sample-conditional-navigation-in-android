package me.gulya.topic.conditionalnavigation.sample.straightforward.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import me.gulya.topic.conditionalnavigation.sample.straightforward.StraightforwardApproachAuthFragment

object StraightforwardApproachAuthScreen : FragmentScreen(
    fragmentCreator = {
        StraightforwardApproachAuthFragment()
    }
)