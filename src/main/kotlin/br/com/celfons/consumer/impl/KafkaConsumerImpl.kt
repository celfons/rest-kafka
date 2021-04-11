package br.com.celfons.consumer.impl

import br.com.celfons.consumer.KafkaConsumer
import br.com.celfons.controller.request.UserRequest
import br.com.celfons.service.UserService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaConsumerImpl : KafkaConsumer {

    @Autowired private lateinit var service: UserService

    @KafkaListener(topics = ["\${kafka.topic.id}"], groupId = "\${kafka.group.id}")
    override fun listen(
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
        @Payload message: String
    ) {
        val request = Gson().fromJson(message, UserRequest::class.java)
        service.create(request)
    }

}
