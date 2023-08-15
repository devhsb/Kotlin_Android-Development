package com.hasib.woof.data

import com.hasib.woof.R
import com.hasib.woof.model.Dog

class Dogs {
    fun getDogsList(): List<Dog> {
        return listOf(
                Dog(dogName = "Dewana", dogAge = 1, dogImage = R.drawable.img1),
                Dog(dogName = "Durdana", dogAge = 3, dogImage = R.drawable.img2),
                Dog(dogName = "Guldana", dogAge = 2, dogImage = R.drawable.img3),
                Dog(dogName = "Rex", dogAge = 3, dogImage = R.drawable.img4),
                Dog(dogName = "Mike", dogAge = 4, dogImage = R.drawable.img5),
                Dog(dogName = "Joke", dogAge = 5, dogImage = R.drawable.img6),
                Dog(dogName = "Topolo", dogAge = 6, dogImage = R.drawable.img7)
            )
    }
}