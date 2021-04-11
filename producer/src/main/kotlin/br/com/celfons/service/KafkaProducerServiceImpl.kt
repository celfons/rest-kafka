package br.com.celfons.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerServiceImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>
): KafkaProducerService {

    override fun send(topic: String, message: String) {
        kafkaTemplate.send(topic, message)
    }
}
