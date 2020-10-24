package com.intuit.truffleshuffle

import android.animation.AnimatorSet
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 *  Unit tests for Animation Debouncer
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class AnimationDebouncerTest {

    @Test
    fun `animate sets animating to true during animation`() {
        val animationDebouncer = AnimationDebouncer()
        animationDebouncer.animate {
            assertFalse(animationDebouncer.isNotAnimating())
            AnimatorSet()
        }
    }

    @Test
    fun `animate sets animating to false after animation`() {
        val animationDebouncer = AnimationDebouncer()
        animationDebouncer.animate { AnimatorSet() }
        assertTrue(animationDebouncer.isNotAnimating())
    }

    @Test
    fun `animate only allows one animation to happen at a time`() {
        var nestedAnimationHappened = false
        val animationDebouncer = AnimationDebouncer()
        animationDebouncer.animate {
            animationDebouncer.animate {
                nestedAnimationHappened = true
                AnimatorSet()
            }
            AnimatorSet()
        }
        assertFalse(nestedAnimationHappened)
    }
}
