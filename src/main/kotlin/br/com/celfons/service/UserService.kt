package br.com.celfons.service

import br.com.celfons.controller.request.UserRequest
import br.com.celfons.controller.response.UserResponse

interface UserService {

    fun create(request: UserRequest): UserResponse

    fun findAll(): List<UserResponse>

}
