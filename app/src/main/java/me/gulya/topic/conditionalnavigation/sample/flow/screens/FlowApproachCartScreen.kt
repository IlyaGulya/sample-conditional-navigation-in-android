package me.gulya.topic.conditionalnavigation.sample.flow.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import me.gulya.topic.conditionalnavigation.sample.flow.FlowApproachCartFragment

object FlowApproachCartScreen : FragmentScreen(
    fragmentCreator = {
        FlowApproachCartFragment.newInstance()
    }
)