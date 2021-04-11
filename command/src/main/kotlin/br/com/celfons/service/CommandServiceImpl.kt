package br.com.celfons.service

import br.com.celfons.commands.CreateUserCommand
import br.com.celfons.events.CreatedUserEvent
import br.com.celfons.events.UpdatedUserEvent
import br.com.celfons.utils.toMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CommandServiceImpl(
    private val producerService: KafkaProducerService,
    @Value("\${kafka.topic}")
    private val topic: String
) : CommandService {

    override fun handler(command: CreateUserCommand) = try {
        CreatedUserEvent(command.id, command.name).also {
            producerService.send(topic, toMessage(it))
        }
    } catch (exception: Exception) {
        throw exception
    }

    override fun handler(command: UpdatedUserEvent) = try {
        //TODO implements business rules, used command, integrations by feign and etc
        UpdatedUserEvent(command.id, command.name).also {
            producerService.send(topic, toMessage(it))
        }
    } catch (exception: Exception) {
        throw exception
    }

}
