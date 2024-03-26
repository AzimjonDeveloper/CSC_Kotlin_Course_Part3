package org.jetbrains.kotlin.course.old.school.functions

import org.jetbrains.kotlin.course.old.school.photo.Accessory
import org.jetbrains.kotlin.course.old.school.photo.Color
import org.jetbrains.kotlin.course.old.school.photo.PhotoCharacter
import org.springframework.stereotype.Service

@Service
class GameFunctionsService {
    fun getAllPossibleColors() = Color.entries.map { it.name.lowercase() }

    private fun String.capitalize() = replaceFirstChar { it.titlecase() }

    private fun String.toColor() = Color.valueOf(capitalize())

    private fun Iterable<String>.toPhotoCharacters() = map { name -> PhotoCharacter.valueOf(name.capitalize()) }

    fun Iterable<String>.findPhoto(colorStr: String) : PhotoCharacter? = this.toPhotoCharacters().find { it.backgroundColor == colorStr.toColor() }

    fun Iterable<String>.groupPhotosByColor(): List<PhotoCharacter> = this.toPhotoCharacters().groupBy { it.backgroundColor }.flatMap { it.value }

    fun Iterable<String>.groupPhotosByHairAndHat(): List<PhotoCharacter> {
        return this.toPhotoCharacters().groupBy { it.hairType } // Group by hair type
            .flatMap { (_, charactersByHairType) -> // For each hair type group
                charactersByHairType.groupBy { it.accessories?.contains(Accessory.Hat) ?: false } // Group by presence of hat
                    .flatMap { (_, charactersByHat) -> charactersByHat } // Flatten the inner map
            }
    }
}
