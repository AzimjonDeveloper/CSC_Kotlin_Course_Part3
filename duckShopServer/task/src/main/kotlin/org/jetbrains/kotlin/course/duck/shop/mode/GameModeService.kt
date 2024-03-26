package org.jetbrains.kotlin.course.duck.shop.mode

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.generateRandomDuck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.jetbrains.kotlin.course.duck.shop.utils.MAX_NUMBER_OF_DUCKS
import org.springframework.stereotype.Service

@Service
class GameModeService {
    fun generateListOfDucks(): List<Duck> = List(MAX_NUMBER_OF_DUCKS) { generateRandomDuck() }

    fun generateSetOfDucks(): Set<Duck> {
        val ducks = mutableSetOf<Duck>()
        while(ducks.size < MAX_NUMBER_OF_DUCKS) {
            ducks.add(generateRandomDuck())
        }
        return ducks
    }

    fun generateMapOfDucks(): Map<Duck, String> {
        val duckMap = mutableMapOf<Duck, String>()
        while (duckMap.size < MAX_NUMBER_OF_DUCKS) {
            val duck = generateRandomDuck()
            duckMap.put(duck, duck.getDescription())
        }

        return duckMap
    }
}
