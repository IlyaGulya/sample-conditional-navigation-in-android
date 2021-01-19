package me.gulya.topic.conditionalnavigation.sample.flow.screens

import cicerone.parcelablecommands.ParcelableCommandsSupportingRouter
import me.gulya.topic.conditionalnavigation.sample.CheckoutScreen

fun CheckoutFlow(
    router: ParcelableCommandsSupportingRouter
) = FlowApproachAuthScreen(CheckoutScreen, router)