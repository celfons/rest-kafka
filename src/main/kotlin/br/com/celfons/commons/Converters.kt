package br.com.celfons.commons

import br.com.celfons.controller.request.UserRequest
import br.com.celfons.controller.response.UserResponse
import br.com.celfons.domain.UserEntity

fun UserRequest.toEntity(): UserEntity = UserEntity(
    id = id
)

fun UserEntity.toResponse(): UserResponse = UserResponse(
    id = id!!,
    createAt = createAt!!
)

fun List<UserEntity>.toResponse(): List<UserResponse> = this.map {
    UserResponse(
        id = it.id!!,
        createAt = it.createAt!!
    )
}
