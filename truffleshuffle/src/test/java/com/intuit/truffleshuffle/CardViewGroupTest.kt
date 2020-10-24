package com.intuit.truffleshuffle

import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.intuit.truffleshuffle.CardViewGroup.GalleryState.DASHBOARD
import com.intuit.truffleshuffle.CardViewGroup.GalleryState.DETAIL
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 *  Unit tests for Card Gallery Percentage View Group
 *  Created by Katie Levy
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class CardViewGroupTest {

    private val context = spyk(getInstrumentation().targetContext) {
        every { resources } returns mockk(relaxed = true)
    }

    private val cardGroup = spyk(CardViewGroup(context)) {
        every { paddingTop } returns 0
        every { measuredWidth } returns 1000
        every { measuredHeight } returns 1700
        every { animationDebouncer } returns AnimationDebouncer()
    }

    @Before
    fun setup() {
        cardGroup.cards = Array(5) { CardMeasurements() }
        cardGroup.galleryState = DETAIL
        cardGroup.widthPercentage = 0.90.toFloat()
        cardGroup.bottomSpacingPercentage = 0.05.toFloat()
        cardGroup.dashboardCardHeightPercentage = 0.21.toFloat()
        cardGroup.topSpacingPercentage = 0.05.toFloat()
    }

    @Test
    fun getStackCardMeasurementsTest() {
        val cardMeasurements = cardGroup.getStackCardMeasurements(1, 100)
        val expectedCardMeasurements = CardMeasurements(100, 855, 0)
        assertEquals(expectedCardMeasurements, cardMeasurements)
    }

    @Test
    fun getStackCardMeasurementsBottomTest() {
        val cardMeasurements = cardGroup.getStackCardMeasurements(0, 100)
        val expectedCardMeasurements = CardMeasurements(100, 900, 0)
        assertEquals(expectedCardMeasurements, cardMeasurements)
    }

    @Test
    fun getDetailCardMeasurementsTest() {
        val cardMeasurements = cardGroup.getDetailCardMeasurements()
        val expectedCardMeasurements = CardMeasurements(85, 900, 1615)
        assertEquals(expectedCardMeasurements, cardMeasurements)
    }

    @Test
    fun getDashboardCardMeasurementsTest() {
        val cardMeasurements = cardGroup.getDashboardCardMeasurements(100)
        val expectedCardMeasurements = CardMeasurements(100, 900, 357)
        assertEquals(expectedCardMeasurements, cardMeasurements)
    }

    @Test
    fun transitionToDashboardTest() {
        cardGroup.galleryState = DETAIL
        cardGroup.fillDashboardValues()
        val expectedCards = arrayOf(
            CardMeasurements(85, 900, 1615),
            CardMeasurements(1700, 765, 0),
            CardMeasurements(1700, 810, 0),
            CardMeasurements(1700, 855, 0),
            CardMeasurements(1700, 900, 0)
        )
        assertArrayEquals(expectedCards, cardGroup.cards)
    }

    @Test
    fun transitionToDetailTest() {
        cardGroup.galleryState = DASHBOARD
        cardGroup.fillDashboardValues()
        val expectedCards = arrayOf(
            CardMeasurements(85, 900, 357),
            CardMeasurements(442, 900, 357),
            CardMeasurements(799, 900, 357),
            CardMeasurements(1156, 900, 357),
            CardMeasurements(1513, 900, 357)
        )
        assertArrayEquals(expectedCards, cardGroup.cards)
    }

    @Test
    fun clickTest() {
        cardGroup.galleryState = DETAIL
        cardGroup.click(3)
        assertEquals(0, cardGroup.selectedCard)
    }

    @Test
    fun clickDashboardTest() {
        cardGroup.galleryState = DASHBOARD
        cardGroup.click(3)
        assertEquals(3, cardGroup.selectedCard)
    }

    @Test
    fun transitionToOneCardTest() {
        cardGroup.selectedCard = 0
        cardGroup.transitionDetailState(3)
        assertEquals(3, cardGroup.selectedCard)
    }

    @Test
    fun initMemoryTest() {
        cardGroup.initMemory()
        assertEquals(0, cardGroup.cards.size)
        assertEquals(0.21f, cardGroup.dashboardCardHeightPercentage)
    }
}
