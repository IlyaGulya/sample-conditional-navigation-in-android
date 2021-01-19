package me.gulya.topic.conditionalnavigation.sample

import androidx.fragment.app.FragmentFactory
import cicerone.parcelablecommands.ParcelableFragmentScreen
import kotlinx.parcelize.Parcelize

@Parcelize
object CheckoutScreen : ParcelableFragmentScreen() {
    override fun createFragment(factory: FragmentFactory) = CheckoutFragment()
}