package br.com.celfons.controller

import br.com.celfons.domain.response.UserResponse
import br.com.celfons.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserQueryController(
    private val service: UserService
) {

    @GetMapping
    fun findAll(): List<UserResponse> = service.findAll()

}
