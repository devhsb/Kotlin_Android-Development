package com.hasib.wellness.model

import com.hasib.wellness.R

class Repository {
    fun dayxProgram(): List<DailyProgram> {
        return listOf(
            DailyProgram(
                day = "Day 1",
                title = "Rev your metabolism with a glass of lemon water",
                description = "Supercharge your day, get your metabolism fired up, and wake up your digestion with a glass of warm lemon water and a pinch of cayenne pepper. Sip on this before you hit play on your morning FitOn workout, or before you sit down for breakfast. ",
                image = R.drawable.day_1
            ),
            DailyProgram(
                day = "Day 2",
                title = "Add a superfood to all of your meals",
                description = "Want to supercharge all of your meals with little to no effort? Simply add one superfood to each of your meals today. Try adding chia or hemp seeds to your morning bowl of oatmeal, avocado to your smoothie, and cilantro to your taco bowls. ",
                image = R.drawable.day_2
            ),
            DailyProgram(
                day = "Day 3",
                title = "Try a green smoothie",
                description = "Ready to amp up your smoothie game? Try a green smoothie today by blending up your usual smoothie recipe with the addition of a handful or two of dark leafy greens. Blend, sip and nourish your body. ",
                image = R.drawable.day_3
            ),
            DailyProgram(
                day = "Day 4",
                title = "Do a 20-minute strength training workout",
                description = "Build some strength today with a FitOn 20-minute strength training workout. Get out of your comfort zone a bit and use those dumbbells you’ve been meaning to add to your fitness routine or grab the resistance bands. Your muscles will thank you later. ",
                image = R.drawable.day_4
            ),
            DailyProgram(
                day = "Day 5",
                title = "Switch up your evening routine",
                description = "If you don’t have a wind-down period where you destress before bed, try switching up your evening routine by trying something new. Take an Epsom salt bath with lavender essential oils, try 10 minutes of meditation, or close out Instagram and read a book instead. Do something to help your mind and body wind down and relax before bed for a better night sleep. ",
                image = R.drawable.day_5
            ),

        )
    }
}