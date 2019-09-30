package com.intuit.truffleshuffle

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.view.View

/**
 * Data object for holding the card measurements for a specific card, as well as, the function
 * to create animator sets for changing the location and size of the card.
 * Created by Katie Levy
 */
data class CardMeasurements(var yValue: Int = 0, var width: Int = 0, var height: Int = 0) {
    /**
     * Set the transitions for the card index for that card's Y value, height, and width
     * @param newY the new y-value for the card
     * @param newHeight the new height for the card
     * @param newWidth the new width for the card
     * @param view the card's view
     * @return the animator set with the y, height, and width animations
     */
    fun getTransitionAnimator(newY: Int, newHeight: Int, newWidth: Int, view: View): Animator {
        val animatorSet = AnimatorSet()
        // change stack card y value, height and width
        val stackYAnimator = getValueAnimator(
                start = yValue,
                end = newY,
                cardDimension = CardDimension.YVALUE,
                view = view)
        val stackHeightAnimator = getValueAnimator(
                start = height,
                end = newHeight,
                cardDimension = CardDimension.HEIGHT,
                view = view)
        val stackWidthAnimator = getValueAnimator(
                start = width,
                end = newWidth,
                cardDimension = CardDimension.WIDTH,
                view = view)
        animatorSet.playTogether(stackYAnimator, stackHeightAnimator, stackWidthAnimator)
        return animatorSet
    }

    /**
     * Creation of a Value Animator for the specified new values
     * @param start the starting position
     * @param end the ending position
     * @param cardDimension whether the transition is for the y-value, width, or height
     * @param view the card's view
     * @return A value animator with the transition
     */
    private fun getValueAnimator(start: Int, end: Int, cardDimension: CardDimension, view: View): ValueAnimator {
        return ValueAnimator.ofInt(start, end).apply {
            addUpdateListener { animation ->
                val animationValue = animation.animatedValue as Int
                when (cardDimension) {
                    CardDimension.YVALUE -> yValue = animationValue
                    CardDimension.HEIGHT -> height = animationValue
                    CardDimension.WIDTH -> width = animationValue
                }
                view.requestLayout()
            }
            duration = CardViewGroup.TRANSITION_ANIMATION_DURATION
        }
    }

    /**
     * The various dimensions in which the card transitions on
     */
    enum class CardDimension { YVALUE, HEIGHT, WIDTH }
}
