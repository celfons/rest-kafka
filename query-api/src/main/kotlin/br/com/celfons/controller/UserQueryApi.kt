package br.com.celfons.controller

import br.com.celfons.controller.response.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus

interface UserQueryApi {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<UserResponse>

}
