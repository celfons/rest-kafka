package br.com.celfons.service

import br.com.celfons.controller.response.UserResponse
import br.com.celfons.repository.UserRepository
import br.com.celfons.utils.BusinessException
import org.springframework.stereotype.Service

@Service
class QueryService(
    val repository: UserRepository
) {

    fun findAll(): List<UserResponse> =
        repository.findAll().map { UserResponse(it.id!!, it.createAt!!) }
            .also { if(it.isEmpty()) throw BusinessException("No have users") }

}
