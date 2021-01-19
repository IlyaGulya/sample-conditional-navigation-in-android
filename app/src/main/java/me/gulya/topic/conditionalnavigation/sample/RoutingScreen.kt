package me.gulya.topic.conditionalnavigation.sample

import com.github.terrakok.cicerone.androidx.FragmentScreen

object RoutingScreen : FragmentScreen(
    fragmentCreator = {
        RoutingFragment.newInstance()
    }
)