package br.com.celfons.service

import br.com.celfons.command.UserCommand
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaConsumerImpl {

    @Autowired private lateinit var service: QueryService

    @KafkaListener(topics = ["\${kafka.topic.id}"], groupId = "\${kafka.group.id}")
    fun listen(
        @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
        @Payload message: String
    ) {

        when (val command = Gson().fromJson(message, UserCommand::class.java)) {
            is UserCommand.CreateUserCommand -> {
                service.create(command)
            }
        }
    }

}
