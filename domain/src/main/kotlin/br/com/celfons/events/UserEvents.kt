package br.com.celfons.events

abstract class UserEvent(
    private val id: Long
)

data class CreatedUserEvent(
    val id: Long,
    val name: String
): UserEvent(id)

data class UpdatedUserEvent(
    val id: Long,
    val name: String
): UserEvent(id)
