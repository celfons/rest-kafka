package br.com.celfons.commons

import br.com.celfons.domain.entity.UserEntity
import br.com.celfons.domain.request.UserRequest
import br.com.celfons.domain.response.UserResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

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

fun UserRequest.toMessage(): String = let { user ->
    ObjectMapper().apply {
        registerKotlinModule()
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        dateFormat = StdDateFormat()
    }.writeValueAsString(user)
}
