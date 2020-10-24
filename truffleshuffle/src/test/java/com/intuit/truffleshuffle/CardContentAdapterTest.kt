package com.intuit.truffleshuffle

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import io.mockk.CapturingSlot
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 *  Unit tests for Card Content Adapter and Customize Adapter
 *  by Katie Levy
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class CardContentAdapterTest {

    lateinit var mockContext: Context

    @Before
    fun setUp() {
        mockContext = mockLayoutInflater()
    }

    @Test
    fun `On CardContentAdapter initialized with data, content must match what was passed in`() {
        val cardContent = CardContent()
        val cardDetailsArray = arrayListOf(cardContent)
        val cardContentAdapter = CustomizeAdapter(cardDetailsArray, mockContext, 0)

        assertEquals(1, cardContentAdapter.count)
        assertEquals(cardContent, cardContentAdapter.getItem(0))
        assertEquals(0, cardContentAdapter.getItemId(0))
    }

    @Test
    fun `On CardContentAdapter initialized with NO data, adapter must be empty`() {
        val cardDetailsArray = ArrayList<CardContent>()
        val cardContentAdapter = CustomizeAdapter(cardDetailsArray, mockContext, 0)

        assertEquals(0, cardContentAdapter.count)
        assertNull(cardContentAdapter.getItem(0))
    }

    @Test
    fun `on getView(), getViewContent() should get called`() {
        val expectedCardView = mockk<View>()
        val content = ArrayList<CardContent>()
        content.add(CardContent())
        val adapter = spyk(CustomizeAdapter(content, mockContext, 0))
        adapter.getView(0, expectedCardView, mockk())
        verify {
            adapter.getViewContent(expectedCardView, any())
        }
    }

    @Test
    fun `on setupAdapter(), cards in cardContentArray should be added to the cardView passed in`() {
        val expectedCardView = mockCardView()
        val adapter = initCardContentAdapter(expectedCardView)
        val cardViewGroup = mockk<CardViewGroup>(relaxed = true)
        adapter.setupAdapter(cardViewGroup)
        verify {
            cardViewGroup.addView(expectedCardView)
        }
    }

    @Test
    fun `on setupAdapter(), cards in cardContentArray should setOnTouchListener`() {
        val expectedCardView = mockCardView()
        val adapter = initCardContentAdapter(expectedCardView)
        val cardViewGroup = mockk<CardViewGroup>(relaxed = true)
        adapter.setupAdapter(cardViewGroup)
        verify {
            expectedCardView.setOnTouchListener(any())
        }
    }

    @Test
    fun `on setupAdapter(), CardViewGroup should be clicked if MotionEvent ACTION_UP`() {
        val expectedCardView = mockCardView()
        val adapter = initCardContentAdapter(expectedCardView)
        val cardViewGroup = mockk<CardViewGroup>(relaxed = true)
        adapter.setupAdapter(cardViewGroup)
        verify {
            cardViewGroup.click(1)
        }
    }

    private fun initCardContentAdapter(expectedCardView: View): CustomizeAdapter {
        val content = ArrayList<CardContent>()
        content.add(CardContent())
        val adapter = spyk(CustomizeAdapter(content, mockContext, 0))
        every {
            adapter.getView(any(), any(), any())
        } answers {
            expectedCardView
        }
        return adapter
    }

    private fun mockCardView(): View {
        val expectedCardView = mockk<View>(relaxed = true)
        val callback = CapturingSlot<View.OnTouchListener>()
        val mockkEvent = mockk<MotionEvent>(relaxed = true)
        every {
            mockkEvent.actionMasked
        } returns MotionEvent.ACTION_UP
        every {
            expectedCardView.setOnTouchListener(capture(callback))
        } answers {
            callback.captured.onTouch(expectedCardView, mockkEvent)
        }
        every { expectedCardView.tag = any() } just Runs
        every {
            expectedCardView.tag
        } returns 1
        return expectedCardView
    }

    private fun mockLayoutInflater(): Context {
        val mockContext = mockk<Context>()
        val mockLayoutInflater = mockk<LayoutInflater>()
        every {
            mockContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
            )
        } returns mockLayoutInflater
        return mockContext
    }
}
