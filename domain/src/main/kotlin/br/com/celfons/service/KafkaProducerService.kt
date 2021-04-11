package br.com.celfons.service

interface KafkaProducerService {

    fun send(topic: String, message: String)

}
