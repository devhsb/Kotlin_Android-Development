package com.hasib.quotes.data

import com.hasib.quotes.R
import com.hasib.quotes.model.Quote

class Quotes {
    fun loadQuotes(): List<Quote> {
        return listOf(
                Quote(
                    imageId = R.drawable.img1, textId =  R.string.q1
                ),
                Quote(
                    imageId = R.drawable.img2, textId =  R.string.q2
                ),
                Quote(
                    imageId = R.drawable.img3, textId =  R.string.q3
                ),
                Quote(
                    imageId = R.drawable.img4, textId =  R.string.q4
                ),
                Quote(
                    imageId = R.drawable.img5, textId =  R.string.q5
                ),
                Quote(
                    imageId = R.drawable.img6, textId =  R.string.q6
                )
            )
    }
}