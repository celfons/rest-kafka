package br.com.celfons.entity

import java.time.LocalDateTime
import java.time.LocalDateTime.now
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "user")
data class UserEntity(
    @Id private val id: Long? = 1,
    private val name: String? = null,
    private val createAt: LocalDateTime? = now()
)
