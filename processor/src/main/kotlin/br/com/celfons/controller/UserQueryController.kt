package br.com.celfons.controller

import br.com.celfons.controller.response.UserResponse
import br.com.celfons.service.QueryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserQueryController(
    private val service: QueryService
): UserQueryApi {

    override fun findAll(): List<UserResponse> = service.findAll().map { UserResponse(it.id!!, it.createAt!!) }

}
