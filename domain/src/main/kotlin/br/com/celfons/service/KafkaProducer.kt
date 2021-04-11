package br.com.celfons.service

interface KafkaProducer {

    fun send(topic: String, message: String)

}
