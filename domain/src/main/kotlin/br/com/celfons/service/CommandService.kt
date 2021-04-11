package br.com.celfons.service

import br.com.celfons.command.CreateUserCommand

interface CommandService {

    fun create(command: CreateUserCommand)

}
