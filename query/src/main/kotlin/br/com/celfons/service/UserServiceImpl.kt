package br.com.celfons.service

import br.com.celfons.commons.BusinessException
import br.com.celfons.commons.toEntity
import br.com.celfons.commons.toResponse
import br.com.celfons.domain.request.UserRequest
import br.com.celfons.domain.response.UserResponse
import br.com.celfons.repository.UserRepository
import br.com.celfons.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val repository: UserRepository
) : UserService {

    override fun create(request: UserRequest): UserResponse = repository.save(request.toEntity()).toResponse()

    override fun findAll(): List<UserResponse> =
        repository.findAll().toResponse().also { if(it.isEmpty()) throw BusinessException("No have users") }

}
