package br.com.celfons.events

abstract class UserEvent(
    private val id: Long
)

data class CreatedUserEvent(
    val id: Long
): UserEvent(id)
