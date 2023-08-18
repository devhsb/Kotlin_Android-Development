package com.hasib.superheroes.Data

import com.hasib.superheroes.Model.Superhero
import com.hasib.superheroes.R

class Data {
    fun getSuperheroes() : List<Superhero> {
        return listOf(
            Superhero(
                title = "Real Hero",
                description = "The java and jetpack hero",
                image = R.drawable.android_superhero1
            ),
            Superhero(
                title = "The Giant Pig",
                description = "King of the world that can defeat every programmer",
                image = R.drawable.android_superhero2
            ),
            Superhero(
                title = "Undefeated Gaul",
                description = "Catch me if you can you bitch",
                image = R.drawable.android_superhero3
            ),
            Superhero(
                title = "Reality Shadow",
                description = "You can find and defeat me in your dreaming only, so keep dreaming son of the bitch",
                image = R.drawable.android_superhero4
            ),
            Superhero(
                title = "Mad Man",
                description = "The master of all others that say iam a gaul, haha you are like a fucking ant for me bitch",
                image = R.drawable.android_superhero5
            ),
            Superhero(
                title = "Ant Man",
                description = "I will eat you if you try to defeat me",
                image = R.drawable.android_superhero6
            )
            )
    }
}