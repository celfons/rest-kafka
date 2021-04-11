package br.com.celfons.service.impl

import br.com.celfons.commons.BusinessException
import br.com.celfons.commons.toEntity
import br.com.celfons.commons.toResponse
import br.com.celfons.controller.request.UserRequest
import br.com.celfons.controller.response.UserResponse
import br.com.celfons.repository.UserRepository
import br.com.celfons.service.UserService
import org.springframework.stereotype.Service
import kotlin.math.hypot

@Service
class UserServiceImpl(
    val repository: UserRepository
) : UserService {

    override fun create(request: UserRequest): UserResponse = repository.save(request.toEntity()).toResponse()

    override fun findAll(): List<UserResponse> =
        repository.findAll().toResponse().also { if(it.isEmpty()) throw BusinessException("No have users") }

}
