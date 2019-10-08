package com.intuit.truffleshuffle

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * Calculates the view group's children's dimensions based on defined percentage attributes
 * These attributes include:
 * - Width percentage: child's width as percentage of the CardViewGroup's width
 * - Dashboard card height percentage: child's height as percentage of the CardViewGroup's height
 * - Top spacing percentage: vertical spacing above the first child as percentage of the CardViewGroup's height
 * - Bottom spacing percentage: vertical spacing below the last child as percentage of the CardViewGroup's height
 *
 * There are two main layout states for the card gallery:
 * 1. Detail view: one card is expanded with specific details of the card while the other cards
 *      are stacked at the bottom of the screen
 * 2. Dashboard view: all cards are displayed with the same size with a summary of each cards' details
 *
 * Created by Katie Levy
 */
open class CardViewGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ViewGroup(context, attrs, defStyleAttr) {

    // Custom View Attributes
    var widthPercentage: Float = 0f
    var dashboardCardHeightPercentage: Float = 0f
    var topSpacingPercentage: Float = 0f
    var bottomSpacingPercentage: Float = 0f

    var galleryState = GalleryState.DETAIL
    var selectedCard: Int = 0

    open val animationDebouncer = AnimationDebouncer()

    private var initialOnLayout = true

    lateinit var cards: Array<CardMeasurements>

    init {
        val customAttributes = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CardViewGroup,
            0, 0)
        try {
            // Percentages to calculate card dimensions
            widthPercentage = customAttributes.getFloat(
                R.styleable.CardViewGroup_widthPercentage, 0.7f)
            dashboardCardHeightPercentage = customAttributes.getFloat(
                R.styleable.CardViewGroup_dashboardCardHeightPercentage, 0.17f)
            topSpacingPercentage = customAttributes.getFloat(
                R.styleable.CardViewGroup_topSpacingPercentage, 0.07f)
            bottomSpacingPercentage = customAttributes.getFloat(
                R.styleable.CardViewGroup_bottomSpacingPercentage, 0.07f)
        } finally {
            customAttributes.recycle()
        }
        initialOnLayout = true
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (childCount == 0) return

        if (animationDebouncer.isNotAnimating() && initialOnLayout) {
            initMemory()
            fillDashboardValues()
        }
        setChildLayouts()
    }

    private fun setChildLayouts() {
        cards.forEachIndexed { index, card ->
            getChildAt(index).apply {
                measure(MeasureSpec.makeMeasureSpec(card.width, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(card.height, MeasureSpec.EXACTLY))
                layout(getChildLeft(card.width),
                    getChildTop(card),
                    getChildRight(card),
                    getChildBottom(card))
            }
        }
    }

    /**
     * Save the current state for when changing between landscape/portrait
     */
    override
    fun onSaveInstanceState(): Parcelable? {
        return Bundle().apply {
            putParcelable("superState", super.onSaveInstanceState())
            putInt("selectedCard", selectedCard)
            putString("dashboardState", galleryState.toString())
        }
    }

    /**
     * Restore the current state for when changing between landscape/portrait
     */
    override
    fun onRestoreInstanceState(state: Parcelable?) {
        (state as Bundle?)?.apply {
            selectedCard = getInt("selectedCard")
            galleryState = GalleryState.valueOf(getString("dashboardState")
                ?: GalleryState.DETAIL.toString())
            super.onRestoreInstanceState(getParcelable("superState"))
        }
    }

    /**
     * Initialize the cards array based on number of cards
     * Override percentages if they are not fit for the number of cards or the measurements of the CardViewGroup
     */
    // Initialize arrays based on number of cards
    fun initMemory() {
        cards = Array(childCount) { CardMeasurements() }
        // Adjustments to if there are more than 4 cards
        if (childCount > 4) {
            topSpacingPercentage = DASHBOARD_CARD_TOP_SPACING_PERCENTAGE_FIVE_CARD
            bottomSpacingPercentage = DASHBOARD_CARD_BOTTOM_SPACING_PERCENTAGE_FIVE_CARD
        }
        val maximumCardHeight = (0.95f - topSpacingPercentage - bottomSpacingPercentage) / childCount

        if (dashboardCardHeightPercentage > maximumCardHeight) {
            dashboardCardHeightPercentage = maximumCardHeight
        }
    }

    /**
     * Fills the values of the y value, height, and width of each card based on
     * the percentages given as custom attributes to the CardViewGroup in the xml
     */
    fun fillDashboardValues() {
        initialOnLayout = false
        var stackTop = calculateStackTop()
        var stackPosition = cards.size - 2

        for (index in 0 until cards.size) {
            when (galleryState) {
                GalleryState.DETAIL -> {
                    if (index == selectedCard) {
                        cards[index] = getDetailCardMeasurements()
                    } else {
                        val newCardMeasurements = getStackCardMeasurements(stackPosition, stackTop)
                        stackTop += stackCardHeight + stackPadding
                        stackPosition--
                        cards[index] = newCardMeasurements
                    }
                }
                GalleryState.DASHBOARD -> {
                    val newY = calculateTopOfCards() + ((getDashboardCardHeight() + getSpacingBetweenDashboardCardsHeight()) * index)
                    cards[index] = getDashboardCardMeasurements(newY)
                }
            }
        }
    }

    /**
     * Get the measurements for a card in the stack, but not the bottom of the stack
     * @param stackPosition the position the card is in on the UI stack
     * @param currentTop the y value of the stack thus far
     * @return CardMeasurements with the y-value, width, and height
     */
    fun getStackCardMeasurements(stackPosition: Int, currentTop: Int): CardMeasurements {
        val newWidthInStack = getChildWidth() - Math.round(stackPosition.toFloat() * 0.05f * getChildWidth().toFloat())

        val newHeight = if (isBottomOfStack(stackPosition)) {
            stackBottomHeight
        } else {
            stackCardHeight
        }
        return CardMeasurements(
            height = newHeight,
            width = newWidthInStack,
            yValue = currentTop
        )
    }

    /**
     * Get the measurements for a card that is the selected card in the detail state
     */
    fun getDetailCardMeasurements(): CardMeasurements {
        return CardMeasurements(
            height = getDetailCardHeight(),
            width = getChildWidth(),
            yValue = this.paddingTop + getTopSpacing())
    }

    /**
     * Get the measurements for a card that is in the dashboard stats
     */
    fun getDashboardCardMeasurements(currentTop: Int): CardMeasurements {
        return CardMeasurements(
            height = getDashboardCardHeight(),
            width = getChildWidth(),
            yValue = currentTop)
    }

    /**
     * Callback for when a card is clicked to transition to either detail or dashboard state
     */
    fun click(selected: Int) {
        when (galleryState) {
            GalleryState.DETAIL -> transitionToDashboardState()
            GalleryState.DASHBOARD -> transitionDetailState(selected)
        }
    }

    /**
     * Transition to view all the cards in a dashboard
     */
    private fun transitionToDashboardState() {
        animationDebouncer.animate {
            val animator = galleryStateAnimator(desiredGalleryState = GalleryState.DASHBOARD)
            cards.foldIndexed(animator) { index, acc, cardMeasurements ->
                val newY = calculateTopOfCards() + ((getDashboardCardHeight() + getSpacingBetweenDashboardCardsHeight()) * index)
                val animation = cardMeasurements.getTransitionAnimator(newY, getDashboardCardHeight(), getChildWidth(), this)
                acc.add(animation)
            }
        }
    }

    /**
     * Transition to view the details of one card depending on the card clicked
     * and move the other cards to a stack at bottom of the screen
     * @param selected the index of the selected card
     */
    fun transitionDetailState(selected: Int) {
        animationDebouncer.animate {
            val animator = galleryStateAnimator(desiredGalleryState = GalleryState.DETAIL)
            selectedCard = selected

            var stackTop = calculateStackTop()
            var stackPosition = cards.size - 2

            cards.foldIndexed(animator) { index, acc, cardLayoutSpecs ->
                val animation = if (index == selectedCard) {
                    cardLayoutSpecs.getTransitionAnimator(calculateTopOfCards(), getDetailCardHeight(), getChildWidth(), this)
                } else {
                    val newHeight =
                        if (isBottomOfStack(stackPosition)) {
                            stackBottomHeight
                        } else {
                            stackCardHeight
                        }
                    val newWidth = getChildWidth() - Math.round(stackPosition.toFloat() * 0.05f * getChildWidth().toFloat())
                    val currentStackTop = stackTop
                    stackTop += stackCardHeight + stackPadding
                    stackPosition--

                    cardLayoutSpecs.getTransitionAnimator(currentStackTop, newHeight, newWidth, this)
                }
                acc.add(animation)
            }
        }
    }

    private fun galleryStateAnimator(desiredGalleryState: GalleryState): AnimatorSet =
        AnimatorSet().also {
            it.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    galleryState = desiredGalleryState
                }
            })
        }

    private fun AnimatorSet.add(other: Animator): AnimatorSet = this.also { it.playTogether(other) }

    private fun isBottomOfStack(stackPosition: Int) = stackPosition == 0

    private fun calculateTopOfCards() = this.paddingTop + getTopSpacing()
    private fun calculateStackTop() = calculateTopOfCards() + getDetailCardHeight() + spaceBelowDetailCardHeight

    private fun getDetailCardHeight() = getParentHeight() - getTopSpacing() - getBelowDetailCardHeight()
    private fun getDashboardCardHeight() = Math.round(getParentHeight() * dashboardCardHeightPercentage)

    private fun getChildWidth() = Math.round(getParentWidth() * widthPercentage)
    private fun getParentHeight() = getParentBottom() - this.paddingTop
    private fun getParentBottom() = this.measuredHeight - this.paddingBottom
    private fun getParentWidth() = this.measuredWidth - this.paddingRight - this.paddingLeft

    private fun getChildLeft(width: Int) = this.paddingLeft + Math.max(0, (getParentWidth() - width) / 2)
    private fun getChildRight(cardLayoutSpec: CardMeasurements) = cardLayoutSpec.width + getChildLeft(cardLayoutSpec.width)
    private fun getChildBottom(cardLayoutSpec: CardMeasurements) = cardLayoutSpec.yValue + cardLayoutSpec.height
    private fun getChildTop(cardLayoutSpec: CardMeasurements) = cardLayoutSpec.yValue
    private fun getBelowDetailCardHeight() = ((stackPadding + stackCardHeight) * (childCount - 2)) + spaceBelowDetailCardHeight + stackBottomHeight
    private fun getTopSpacing(): Int = Math.round(getParentHeight() * topSpacingPercentage)
    private fun getBottomSpacing() = Math.round(getParentHeight() * bottomSpacingPercentage)
    private fun getSpacingBetweenDashboardCardsHeight() = Math.max(0, Math.round((getParentHeight().toFloat() - getTopSpacing().toFloat() - getBottomSpacing().toFloat() - (getDashboardCardHeight() * childCount).toFloat()) / (childCount - 1)))

    private val stackPadding = resources.getDimension(R.dimen.card_stack_padding).toInt()
    private val stackBottomHeight = resources.getDimension(R.dimen.card_stack_bottom_height).toInt()
    private val stackCardHeight = resources.getDimension(R.dimen.card_stack_height).toInt()
    private val spaceBelowDetailCardHeight = resources.getDimension(R.dimen.card_stack_top_margin).toInt()

    companion object {
        private const val DASHBOARD_CARD_TOP_SPACING_PERCENTAGE_FIVE_CARD = 0.02f
        private const val DASHBOARD_CARD_BOTTOM_SPACING_PERCENTAGE_FIVE_CARD = 0.02f
        const val TRANSITION_ANIMATION_DURATION: Long = 200
    }

    enum class GalleryState { DASHBOARD, DETAIL }
}
