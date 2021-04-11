package br.com.celfons.consumer

interface KafkaConsumer {
    fun listen(topic: String, message: String)
}
