package com.digitalturbine.assessment

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.digitalturbine.assessment.activities.MainActivity
import com.digitalturbine.assessment.extensions.isGone
import com.digitalturbine.assessment.extensions.isVisible
import com.digitalturbine.assessment.extensions.onView
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI test for MainActivity
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun checkLoadingView() {
        launchActivity<MainActivity>().use {
            R.id.progress_bar.onView().isVisible()
            R.id.recycler_view.onView().isGone()
            R.id.error_views.onView().isGone()
        }
    }
}