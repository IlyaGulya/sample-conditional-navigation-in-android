package cicerone.parcelablecommands

import android.os.Parcelable
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import kotlinx.parcelize.Parcelize

interface ParcelableCommand : Command, Parcelable {
    fun toCiceroneCommand(): Command
}

/**
 * Opens new screen.
 */
@Parcelize
data class ParcelableForward(
    val screen: ParcelableScreen,
    val clearContainer: Boolean
) : ParcelableCommand {
    override fun toCiceroneCommand(): Command = Forward(screen.asCiceroneScreen(), clearContainer)
}

/**
 * Replaces the current screen.
 */
@Parcelize
data class ParcelableReplace(val screen: ParcelableScreen) : ParcelableCommand {
    override fun toCiceroneCommand(): Command = Replace(screen.asCiceroneScreen())
}

/**
 * Rolls fragmentBack the last transition from the screens chain.
 */
@Parcelize
class ParcelableBack : ParcelableCommand {
    override fun toCiceroneCommand(): Command = Back()
}

/**
 * Rolls fragmentBack to the needed screen from the screens chain.
 *
 * Behavior in the case when no needed screens found depends on an implementation of the [com.github.terrakok.cicerone.Navigator]
 * But the recommended behavior is to return to the root.
 */
@Parcelize
class ParcelableBackTo(val screen: ParcelableScreen?) : ParcelableCommand {
    override fun toCiceroneCommand(): Command = BackTo(screen?.asCiceroneScreen())
}