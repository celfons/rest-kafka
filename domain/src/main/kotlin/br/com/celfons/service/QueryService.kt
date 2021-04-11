package br.com.celfons.service

import br.com.celfons.command.CreateUserCommand
import br.com.celfons.entity.UserEntity

interface QueryService {

    fun create(command: CreateUserCommand): UserEntity

    fun findAll(): List<UserEntity>

}
