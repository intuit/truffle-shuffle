package com.intuit.truffleshuffle

import android.content.Context
import android.view.LayoutInflater
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 *  Unit tests for Card Content Adapter and Customize Adapter
 *  by Katie Levy
 */
@RunWith(RobolectricTestRunner::class)
class CardContentAdapterTest {
    @Test
    fun cardContentAdapterTest() {
        val cardContent = CardContent()
        val cardDetailsArray = arrayListOf(cardContent)

        val mockContext = mock<Context>()
        val mockLayoutInflater = mock<LayoutInflater>()
        doReturn(mockLayoutInflater).whenever(mockContext).getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        val cardContentAdapter = CustomizeAdapter(cardDetailsArray, mockContext, 0)

        assertEquals(1, cardContentAdapter.count)
        assertEquals(cardContent, cardContentAdapter.getItem(0))
        assertEquals(0, cardContentAdapter.getItemId(0))
    }

    @Test
    fun cardContentAdapterEmptyTest() {
        val cardDetailsArray = ArrayList<CardContent>()

        val mockContext = mock<Context>()
        val mockLayoutInflater = mock<LayoutInflater>()
        doReturn(mockLayoutInflater).whenever(mockContext).getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        val cardContentAdapter = CustomizeAdapter(cardDetailsArray, mockContext, 0)

        assertEquals(0, cardContentAdapter.count)
        assertNull(cardContentAdapter.getItem(0))
    }
}
