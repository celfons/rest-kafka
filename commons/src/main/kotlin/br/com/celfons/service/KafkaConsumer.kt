package br.com.celfons.service

interface KafkaConsumer {
    fun listen(topic: String, message: String)
}
