package com.intuit.truffle.shuffle.cardGallery

import android.content.Context
import android.view.View
import android.widget.TextView
import com.intuit.truffle.shuffle.R
import java.util.ArrayList

/**
 * The custom adapter for mapping the data in the CardContent object to the specific view
 * Created by Katie Levy
 */
class CustomizeAdapter(cardDetails: ArrayList<CardContent>,
                       mContext: Context, layout: Int)
    : com.intuit.truffleshuffle.CardContentAdapter<CardContent>(cardDetails, mContext, layout) {

    /**
     * Add the content to the card's view
     * @param view the card's view
     * @param cardContent the data object of card content
     */
    // TODO: map the data content to your view
    override fun getViewContent(view: View, cardContent: CardContent) {
        (view.findViewById<View>(R.id.txt_card_description) as TextView?)?.text = cardContent.uniqueCardContent
    }
}
