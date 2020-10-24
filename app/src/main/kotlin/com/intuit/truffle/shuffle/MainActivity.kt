package com.intuit.truffle.shuffle

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.intuit.truffle.shuffle.cardGallery.CardContent
import com.intuit.truffle.shuffle.cardGallery.CustomizeAdapter
import com.intuit.truffleshuffle.CardViewGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCardGallery()
    }

    // TODO: Add your specific details for each unique card
    // Change the number of cards by adding to arrayOfCardPercentageDetails and view will automatically adjust
    private fun getCardDetails(): ArrayList<CardContent> {
        return arrayListOf(
            CardContent("Place Content Here"),
            CardContent("And more content here"),
            CardContent("And even more content here"),
            CardContent("Don't forget about here too!"),
            CardContent("Don't forget about here too!"),
            CardContent("Don't forget about here too!"),
            CardContent("Don't forget about here too!"),
            CardContent("Don't forget about here too!"),
            CardContent("Don't forget about here too!"))
    }

    // TODO: Add a layout file with your personal card view
    private fun getInnerCardLayout(): Int = R.layout.card_layout

    private fun setupCardGallery() {
        val cardLayout = findViewById<View>(R.id.card_gallery_percentage_view_group) as CardViewGroup
        CustomizeAdapter(getCardDetails(), this.baseContext, getInnerCardLayout())
            .setupAdapter(cardLayout)
    }
}
