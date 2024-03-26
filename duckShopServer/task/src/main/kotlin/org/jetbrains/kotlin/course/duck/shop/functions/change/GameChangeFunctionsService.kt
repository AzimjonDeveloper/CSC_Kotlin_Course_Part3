package org.jetbrains.kotlin.course.duck.shop.functions.change

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.generateRandomDuck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class GameChangeFunctionsService  {
    fun MutableList<Duck>.addRandomDuck(): Duck {
        val duck = generateRandomDuck()
        this.add(duck)

        return duck
    }

    fun MutableSet<Duck>.addRandomDuck(): Duck {
        var duck: Duck
        do {
            duck = generateRandomDuck()
        } while (this.contains(duck))

        this.add(duck)
        return duck
    }

    fun MutableMap<Duck, String>.addRandomDuck(): Pair<Duck, String> {
        var duck: Duck

        do {
            duck = generateRandomDuck()

        } while (this.any {it.key.customName == duck.customName && it.value == duck.getDescription()})

//        put(duck, duck.getDescription())
        return duck to duck.getDescription()
    }

    fun List<Duck>.removeRandomDuck(): List<Duck> {
        val mutableList = this.toMutableList()
        mutableList.removeAt(Random.nextInt(mutableList.size))
        return  mutableList
    }

    fun Set<Duck>.removeRandomDuck(): Set<Duck> {
        val mutableSet = this.toMutableSet()
        mutableSet.remove(mutableSet.random())
        return mutableSet
    }

    fun Map<Duck, String>.removeRandomDuck(): Map<Duck, String> {
        val mutableMap = this.toMutableMap()
        mutableMap.remove(mutableMap.keys.random())
        return mutableMap
    }
}
