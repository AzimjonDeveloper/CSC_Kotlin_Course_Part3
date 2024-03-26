package org.jetbrains.kotlin.course.tamagotchi.game

import org.jetbrains.kotlin.course.tamagotchi.models.Command
import org.jetbrains.kotlin.course.tamagotchi.models.Mode
import org.springframework.stereotype.Service

@Service
class GameService {
    val commands: ArrayDeque<Command> = ArrayDeque()

    companion object {
        private const val MAX_CAPACITY = 16
    }

    fun addCommand(command: Command): Boolean = if(commands.size < org.jetbrains.kotlin.course.tamagotchi.game.GameService.Companion.MAX_CAPACITY) {
            commands.add(command)
            true
        } else {
            false
        }

    fun getCommand(mode: Mode): Command? = when (mode) {
        Mode.Queue -> commands.removeFirstOrNull()
        else -> commands.removeLastOrNull()
    }
}
