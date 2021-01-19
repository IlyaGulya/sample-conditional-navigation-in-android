package me.gulya.topic.conditionalnavigation.sample.straightforward.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import me.gulya.topic.conditionalnavigation.sample.straightforward.StraightforwardApproachCartFragment

object StraightforwardApproachCartScreen : FragmentScreen(
    fragmentCreator = {
        StraightforwardApproachCartFragment()
    }
)