package br.com.celfons.service

import br.com.celfons.command.CreateUserCommand
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CommandServiceImpl(
    private val producer: KafkaProducer,
    @Value("\${kafka.topic.id}")
    private val topic: String
) : CommandService {

    override fun create(command: CreateUserCommand) = try {
        val message = ObjectMapper().apply {
            registerKotlinModule()
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            dateFormat = StdDateFormat()
        }.writeValueAsString(command)
        producer.send(topic, message)
    } catch (exception: Exception) {
        throw exception
    }

}
