package com.intuit.truffleshuffle

import android.content.Context
import android.view.View

/**
 *  Data objects to be used in tests
 */
class CardContent

class CustomizeAdapter(
    cardDetails: java.util.ArrayList<CardContent>,
    mContext: Context,
    layout: Int
) : com.intuit.truffleshuffle.CardContentAdapter<CardContent>(cardDetails, mContext, layout) {
    override fun getViewContent(view: View, cardContent: CardContent) {
        // Do nothing
    }
}
