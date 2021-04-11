package br.com.celfons.producer.impl

import br.com.celfons.controller.request.UserRequest
import br.com.celfons.producer.KafkaProducer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>
): KafkaProducer {

    override fun create(request: UserRequest) {
        val jsonMapper = ObjectMapper().apply {
            registerKotlinModule()
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            dateFormat = StdDateFormat()
        }
        val message = jsonMapper.writeValueAsString(request)
        kafkaTemplate.send("ksql", message)
    }
}
