package br.com.celfons.producer

import br.com.celfons.controller.request.UserRequest

interface KafkaProducer {
    fun create(request: UserRequest)
}
