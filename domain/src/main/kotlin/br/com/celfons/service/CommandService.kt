package br.com.celfons.service

import br.com.celfons.commands.CreateUserCommand
import br.com.celfons.events.UpdatedUserEvent
import br.com.celfons.events.UserEvent

interface CommandService {

    fun handler(command: CreateUserCommand): UserEvent

    fun handler(command: UpdatedUserEvent): UserEvent

}
