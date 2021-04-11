package br.com.celfons.service

import br.com.celfons.events.CreatedUserEvent
import br.com.celfons.events.UserEvent

interface ProcessorService {

    fun handler(event: CreatedUserEvent): UserEvent

}
