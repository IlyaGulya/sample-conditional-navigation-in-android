package me.gulya.topic.conditionalnavigation.sample

import cicerone.parcelablecommands.ParcelableCommandsSupportingRouter
import com.github.terrakok.cicerone.Cicerone

object DI {
    val cicerone = Cicerone.create(ParcelableCommandsSupportingRouter())
    val navigatorHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    var isUserAuthorized = false
}