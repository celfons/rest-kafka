package br.com.celfons.service

import br.com.celfons.domain.request.UserRequest

interface KafkaProducer {
    fun createUser(request: UserRequest, topic: String)
}
