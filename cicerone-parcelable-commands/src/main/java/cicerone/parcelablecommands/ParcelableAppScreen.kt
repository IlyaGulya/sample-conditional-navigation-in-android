package cicerone.parcelablecommands

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface ParcelableScreen : Screen, Parcelable {
    fun asCiceroneScreen(): Screen
}

sealed class ParcelableAppScreen : ParcelableScreen

abstract class ParcelableFragmentScreen : ParcelableAppScreen() {
    override val screenKey: String get() = super.screenKey
    abstract fun createFragment(factory: FragmentFactory): Fragment

    override fun asCiceroneScreen(): FragmentScreen {
        return FragmentScreen(
            key = screenKey,
            fragmentCreator = { createFragment(it) }
        )
    }
}

abstract class ParcelableActivityScreen : ParcelableAppScreen() {
    override val screenKey: String get() = super.screenKey
    abstract fun createIntent(context: Context): Intent

    override fun asCiceroneScreen(): Screen {
        return ActivityScreen(
            key = screenKey,
            intentCreator = { context -> createIntent(context) }
        )
    }
}