package br.com.celfons.commands

import br.com.celfons.events.UserEvent

abstract class UserCommand(
    private val id: Long
)

data class CreateUserCommand(
    val id: Long,
    val name: String
): UserCommand(id)

data class UpdateUserCommand(
    val id: Long,
    val name: String
): UserEvent(id)
