package me.gulya.topic.conditionalnavigation.sample.straightforward

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import me.gulya.topic.conditionalnavigation.sample.DI
import me.gulya.topic.conditionalnavigation.sample.R

class StraightforwardApproachAuthFragment : Fragment(R.layout.fragment_auth) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isVisible = true

        view.findViewById<Button>(R.id.button_authorization_successful)
            .setOnClickListener {
                DI.isUserAuthorized = true
                setFragmentResult(
                    REQUEST_KEY, bundleOf(
                        RESULT_KEY to AuthResult.SUCCESSFUL
                    )
                )
                DI.router.exit()
            }

        view.findViewById<Button>(R.id.button_authorization_unsuccessful)
            .setOnClickListener {
                setFragmentResult(
                    REQUEST_KEY, bundleOf(
                        RESULT_KEY to AuthResult.UNSUCCESSFUL
                    )
                )
                DI.router.exit()
            }
    }

    companion object {
        const val REQUEST_KEY = "REQUEST_KEY"
        const val RESULT_KEY = "RESULT_KEY"

        fun extractResult(bundle: Bundle): AuthResult = bundle.getSerializable(RESULT_KEY) as AuthResult
    }
}

enum class AuthResult {
    SUCCESSFUL,
    UNSUCCESSFUL
}