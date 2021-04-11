package br.com.celfons.service

import br.com.celfons.commands.CreateUserCommand
import br.com.celfons.utils.toMessage
import br.com.celfons.events.CreatedUserEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CommandServiceImpl(
    private val producer: KafkaProducer,
    @Value("\${kafka.topic.id}")
    private val topic: String
) : CommandService {

    override fun handler(command: CreateUserCommand) = try {
        val message = toMessage(command)
        producer.send(topic, message)
        CreatedUserEvent(command.id)
    } catch (exception: Exception) {
        throw exception
    }

}
