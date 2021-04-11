package br.com.celfons.controller

import br.com.celfons.domain.request.UserRequest
import br.com.celfons.service.KafkaProducer
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserCommandController(
    private val producer: KafkaProducer,
    @Value("\${kafka.topic.id}")
    private val topic: String
) {

    @PostMapping
    fun create(@RequestBody request: UserRequest) = producer.createUser(request, topic)

}
