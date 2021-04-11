package br.com.celfons.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>
): KafkaProducer {

    override fun send(topic: String, message: String) {
        kafkaTemplate.send(topic, message)
    }
}
