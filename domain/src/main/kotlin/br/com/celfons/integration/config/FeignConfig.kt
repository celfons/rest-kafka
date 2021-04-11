package br.com.celfons.integration.config

import br.com.celfons.integration.KafkaRepository
import feign.Feign
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class FeignConfig(
    @Value("\${kafka.host.url}")
    private val kafkaUrl: String
) {

    @Bean
    fun kafkaApi(): KafkaRepository =
        Feign.builder().target(KafkaRepository::class.java, kafkaUrl)

}