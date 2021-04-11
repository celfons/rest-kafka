package br.com.celfons.controller

import br.com.celfons.command.CreateUserCommand
import br.com.celfons.controller.request.UserRequest
import br.com.celfons.service.CommandService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserCommandController(
    val service: CommandService
): UserCommandApi {

    override fun create(@RequestBody request: UserRequest) = try {
        val command = CreateUserCommand(request.id)
        service.create(command)
    } catch (exception: Exception) {
        throw exception
    }

}
