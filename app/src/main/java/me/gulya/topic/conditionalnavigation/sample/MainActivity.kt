package me.gulya.topic.conditionalnavigation.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    private val navigator by lazy {
        AppNavigator(
            activity = this,
            containerId = R.id.container
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            DI.router.replaceScreen(RoutingScreen)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        DI.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        DI.navigatorHolder.removeNavigator()
        super.onPause()
    }
}

