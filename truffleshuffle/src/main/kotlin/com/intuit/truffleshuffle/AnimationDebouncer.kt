package com.intuit.truffleshuffle

import android.animation.Animator
import android.animation.AnimatorListenerAdapter

/**
 *  Ensure the animation is occurring only once after the user selects a card
 *  by keeping track of if the animation is in process
 */
class AnimationDebouncer {
    private var isAnimating = false

    /**
     * Whether an animation is currently in process
     */
    fun isNotAnimating() = !isAnimating

    private val endAnimationListener = object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            isAnimating = false
        }
    }

    /**
     * Attempt to start an animation but only if there is not another animation in process
     * @param animatorCreator lambda function of the animation to start
     */
    fun animate(animatorCreator: () -> Animator) {
        if (isAnimating) return

        isAnimating = true
        val animator = animatorCreator()
        animator.addListener(endAnimationListener)
        animator.start()
    }

}