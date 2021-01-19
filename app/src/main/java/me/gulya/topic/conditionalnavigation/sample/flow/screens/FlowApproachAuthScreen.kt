package me.gulya.topic.conditionalnavigation.sample.flow.screens

import cicerone.parcelablecommands.ParcelableCommandsSupportingRouter
import cicerone.parcelablecommands.ParcelableScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import me.gulya.topic.conditionalnavigation.sample.flow.AuthSettings
import me.gulya.topic.conditionalnavigation.sample.flow.FlowApproachAuthFragment

data class FlowApproachAuthScreen(
    val successAuthScreen: ParcelableScreen,
    val router: ParcelableCommandsSupportingRouter,
) : FragmentScreen(
    fragmentCreator = {
        FlowApproachAuthFragment.newInstance(
            AuthSettings(
                successAuthCommands = listOf(router.backCommand(), router.navigateToCommand(successAuthScreen)),
                unsuccessfulAuthCommands = listOf(router.backCommand())
            )
        )
    }
)