package br.com.celfons.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import br.com.celfons.events.UserEvent

fun <T> toMessage(data: T): String =
    ObjectMapper().apply {
        registerKotlinModule()
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        dateFormat = StdDateFormat()
    }.writeValueAsString(data)

fun String.toEvent(): UserEvent =
    ObjectMapper().readValue(this, UserEvent::class.java)
