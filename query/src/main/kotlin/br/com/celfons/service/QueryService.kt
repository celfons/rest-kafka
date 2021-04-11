package br.com.celfons.service

import br.com.celfons.repository.UserRepository
import br.com.celfons.entity.UserEntity
import br.com.celfons.utils.BusinessException
import org.springframework.stereotype.Service

@Service
class QueryServiceImpl(
    val repository: UserRepository
): QueryService {

    override fun findAll(): List<UserEntity> =
        repository.findAll().also { if(it.isEmpty()) throw BusinessException("No have users") }

    override fun findById(id: Long): UserEntity =
        repository.findById(id).orElseThrow { throw BusinessException("User not Found") }

    override fun findByName(name: String): UserEntity = repository.findByName(name)

}
