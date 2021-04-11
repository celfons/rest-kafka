package br.com.celfons.service

import br.com.celfons.entity.UserEntity

interface QueryService {

    fun findAll(): List<UserEntity>

}
