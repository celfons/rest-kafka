package br.com.celfons.controller.response

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val createAt: LocalDateTime
)
