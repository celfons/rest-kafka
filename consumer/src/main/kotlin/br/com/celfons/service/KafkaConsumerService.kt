package br.com.celfons.service

import br.com.celfons.utils.toEvent
import br.com.celfons.events.CreatedUserEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaConsumerService(
    val service: ProcessorService
) {

    @KafkaListener(topics = ["\${kafka.topic.id}"], groupId = "\${kafka.group.id}")
    fun listen(
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
        @Payload message: String
    ) {

        when (val event = message.toEvent()) {
            is CreatedUserEvent -> {
                service.handler(event)
            }
        }
    }

}
