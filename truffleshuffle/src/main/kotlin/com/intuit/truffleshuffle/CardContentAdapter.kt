package com.intuit.truffleshuffle

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import java.util.ArrayList

/**
 * The adapter for mapping the array of card contents to the specific views in the card gallery
 * Note that the array of contents is generic.
 * Created by Katie Levy
 */
abstract class CardContentAdapter<T : Any?>(private val cardContentArray: ArrayList<T>,
                                            mContext: Context, private val layout: Int) : BaseAdapter() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)

    /**
     * Get the count of items in the adapter
     * @return number of items in the adapter
     */
    override fun getCount(): Int {
        return cardContentArray.size
    }

    /**
     * Get a specific item in the adapter's array
     * @param i index of the item
     * @return the item in the array or null
     */
    override fun getItem(i: Int): T? {
        return if (i < count) {
            cardContentArray[i]
        } else {
            null
        }
    }

    /**
     * Get the id of the item
     * @param i index of the item
     * @return the id for that item
     */
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    /**
     * Inflate the card view with the specific content in the adapter's array
     * This can be customized for the view in @see cardGallery.CustomizeAdapter
     * @param position the index of the card
     * @param cardView the card's view
     * @param parent the parent view of the card's view
     * @return the view with the content filled into the view
     */
    override fun getView(position: Int, cardView: View?, parent: ViewGroup?): View {
        val view = cardView ?: layoutInflater.inflate(layout, parent, false)
        getViewContent(view, cardContentArray[position])
        return view
    }

    /**
     * Add the content to the card's view
     * @param view the card's view
     * @param cardContent the data object of card content
     */
    abstract fun getViewContent(view: View, cardContent: T)

    /**
     * Setup the views inside the card view group with the data in the adapter
     * @param cardViewGroup the custom view group of all the cards
     */
    fun setupAdapter(cardViewGroup: CardViewGroup) {
        for (index in cardContentArray.indices) {
            val cardView = getView(index, null, cardViewGroup)
                    .apply { tag = index }
            cardViewGroup.addView(cardView)
            cardView.setOnTouchListener(View.OnTouchListener { view, event ->
                return@OnTouchListener when (event.actionMasked) {
                    MotionEvent.ACTION_DOWN -> true
                    MotionEvent.ACTION_UP -> {
                        cardViewGroup.click(view.tag as Int)
                        true
                    } else -> false
                }
            })
        }
    }
}
