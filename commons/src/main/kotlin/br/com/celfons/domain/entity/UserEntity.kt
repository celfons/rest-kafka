package br.com.celfons.domain.entity

import java.time.LocalDateTime
import java.time.LocalDateTime.now
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "user")
data class UserEntity(
    @Id val id: Long? = 1,
    val createAt: LocalDateTime? = now()
)
