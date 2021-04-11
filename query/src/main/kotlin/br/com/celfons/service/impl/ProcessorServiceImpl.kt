package br.com.celfons.service.impl

import br.com.celfons.events.CreatedUserEvent
import br.com.celfons.repository.UserRepository
import br.com.celfons.repository.entity.UserEntity
import br.com.celfons.service.ProcessorService
import org.springframework.stereotype.Service

@Service
class ProcessorServiceImpl(
    val repository: UserRepository
) : ProcessorService {

    override fun handler(event: CreatedUserEvent) = repository.save(UserEntity(event.id)).run { event }

}
