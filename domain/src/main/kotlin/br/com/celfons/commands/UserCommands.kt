package br.com.celfons.commands

abstract class UserCommand(
    private val id: Long
)

data class CreateUserCommand(
    val id: Long
): UserCommand(id)
