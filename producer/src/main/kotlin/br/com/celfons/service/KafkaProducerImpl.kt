package br.com.celfons.service

import br.com.celfons.commons.toMessage
import br.com.celfons.domain.request.UserRequest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>
): KafkaProducer {

    override fun createUser(request: UserRequest, topic: String) {
        kafkaTemplate.send(topic, request.toMessage())
    }
}
