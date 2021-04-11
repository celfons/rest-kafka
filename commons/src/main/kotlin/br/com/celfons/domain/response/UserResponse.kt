package br.com.celfons.domain.response

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val createAt: LocalDateTime
)
