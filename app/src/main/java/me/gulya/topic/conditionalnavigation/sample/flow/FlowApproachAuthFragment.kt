package me.gulya.topic.conditionalnavigation.sample.flow

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import cicerone.parcelablecommands.ParcelableCommand
import kotlinx.parcelize.Parcelize
import me.gulya.topic.conditionalnavigation.sample.DI
import me.gulya.topic.conditionalnavigation.sample.R

class FlowApproachAuthFragment : Fragment(R.layout.fragment_auth) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val settings = requireArguments().getParcelable<AuthSettings>(EXTRA_SETTINGS)!!

        view.findViewById<Button>(R.id.button_authorization_successful).setOnClickListener {
            successAuth(settings)
        }

        view.findViewById<Button>(R.id.button_authorization_unsuccessful).setOnClickListener {
            unsuccessAuth(settings)
        }

        if (DI.isUserAuthorized) {
            view.post {
                successAuth(settings)
            }
        } else {
            view.isVisible = true
        }
    }

    private fun successAuth(settings: AuthSettings) {
        DI.isUserAuthorized = true
        DI.router.processCommands(settings.successAuthCommands)
    }

    private fun unsuccessAuth(settings: AuthSettings) {
        DI.router.processCommands(settings.unsuccessfulAuthCommands)
    }

    companion object {
        const val EXTRA_SETTINGS = "EXTRA_SETTINGS"

        fun newInstance(settings: AuthSettings): FlowApproachAuthFragment {
            return FlowApproachAuthFragment().apply {
                arguments = bundleOf(
                    EXTRA_SETTINGS to settings
                )
            }
        }
    }
}

@Parcelize
data class AuthSettings(
    val successAuthCommands: List<ParcelableCommand>,
    val unsuccessfulAuthCommands: List<ParcelableCommand>,
) : Parcelable