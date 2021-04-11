package br.com.celfons.service

import br.com.celfons.commands.CreateUserCommand
import br.com.celfons.events.CreatedUserEvent

interface CommandService {

    fun handler(command: CreateUserCommand): CreatedUserEvent

}
