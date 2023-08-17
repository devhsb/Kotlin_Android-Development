package com.hasib.woof.data

import com.hasib.woof.R
import com.hasib.woof.model.Dog

class Dogs {
    fun getDogsList(): List<Dog> {
        return listOf(
                Dog(dogName = "Dewana", dogAge = 1, dogImage = R.drawable.img1,
                    dogHobbie = "Eating meat in middle of party"),
                Dog(dogName = "Durdana", dogAge = 3, dogImage = R.drawable.img2,
                    dogHobbie = "Sleeping 24/7"),
                Dog(dogName = "Guldana", dogAge = 2, dogImage = R.drawable.img3,
                    dogHobbie = "Playing hide and seek with childrens"),
                Dog(dogName = "Rex", dogAge = 3, dogImage = R.drawable.img4,
                    dogHobbie = "Running in yard"),
                Dog(dogName = "Mike", dogAge = 4, dogImage = R.drawable.img5,
                    dogHobbie = "Barking in middle of night"),
                Dog(dogName = "Joke", dogAge = 5, dogImage = R.drawable.img6,
                    dogHobbie = "Making people laugh and happy"),
                Dog(dogName = "Topolo", dogAge = 6, dogImage = R.drawable.img7,
                    dogHobbie = "Play with childs and eating soft meat")
            )
    }
}