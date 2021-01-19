package cicerone.parcelablecommands

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Router

class ParcelableCommandsSupportingRouter : Router() {
    fun processCommands(vararg commands: ParcelableCommand) {
        val ciceroneCommands = commands.map { it.toCiceroneCommand() }.toTypedArray()
        executeCommands(*ciceroneCommands)
    }

    fun processCommands(vararg commands: Command) {
        executeCommands(*commands)
    }

    fun processCommands(commands: List<ParcelableCommand>) {
        processCommands(*commands.toTypedArray())
    }

    fun navigateTo(screen: ParcelableScreen, clearContainer: Boolean = true) {
        super.navigateTo(screen.asCiceroneScreen(), clearContainer)
    }

    fun navigateToCommand(screen: ParcelableScreen, clearContainer: Boolean = true): ParcelableCommand {
        return ParcelableForward(screen, clearContainer)
    }

    fun newRootScreen(screen: ParcelableScreen) {
        super.newRootScreen(screen.asCiceroneScreen())
    }

    fun newRootScreenCommand(screen: ParcelableScreen): List<ParcelableCommand> {
        return listOf(ParcelableBackTo(null), ParcelableReplace(screen))
    }

    fun replaceScreen(screen: ParcelableScreen) {
        super.replaceScreen(screen.asCiceroneScreen())
    }

    fun replaceScreenCommand(screen: ParcelableScreen): ParcelableCommand {
        return ParcelableReplace(screen)
    }

    fun backTo(screen: ParcelableScreen?) {
        super.backTo(screen?.let { screen.asCiceroneScreen() })
    }

    fun backToCommand(screen: ParcelableScreen?): ParcelableCommand {
        return ParcelableBackTo(screen)
    }

    fun newChain(vararg screens: ParcelableScreen, showOnlyTopScreenView: Boolean = true) {
        val ciceroneScreens = screens.map { it.asCiceroneScreen() }.toTypedArray()
        super.newChain(*ciceroneScreens, showOnlyTopScreenView = showOnlyTopScreenView)
    }

    fun newChainCommand(vararg screens: ParcelableScreen, showOnlyTopScreenView: Boolean = true): List<ParcelableCommand> {
        return screens.map { ParcelableForward(it, showOnlyTopScreenView) }
    }

    fun newRootChain(vararg screens: ParcelableScreen, showOnlyTopScreenView: Boolean = true) {
        val ciceroneScreens = screens.map { it.asCiceroneScreen() }.toTypedArray()
        super.newRootChain(*ciceroneScreens, showOnlyTopScreenView = showOnlyTopScreenView)
    }

    fun newRootChainCommand(vararg screens: ParcelableScreen, showOnlyTopScreenView: Boolean = true): List<ParcelableCommand> {
        return screens.mapIndexed { index, screen ->
            if (index == 0) {
                ParcelableReplace(screen)
            } else {
                ParcelableForward(screen, showOnlyTopScreenView)
            }
        }
    }

    fun backCommand(): ParcelableCommand {
        return ParcelableBack()
    }
}