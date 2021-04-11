package br.com.celfons.service

import br.com.celfons.domain.request.UserRequest
import br.com.celfons.domain.response.UserResponse

interface UserService {

    fun create(request: UserRequest): UserResponse

    fun findAll(): List<UserResponse>

}
