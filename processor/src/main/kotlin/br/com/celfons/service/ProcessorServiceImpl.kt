package br.com.celfons.service

import br.com.celfons.events.CreatedUserEvent
import br.com.celfons.repository.UserRepository
import br.com.celfons.entity.UserEntity
import org.springframework.stereotype.Service

@Service
class ProcessorServiceImpl(
    val repository: UserRepository
) : ProcessorService {

    override fun handler(event: CreatedUserEvent) = repository.save(UserEntity(event.id)).run { event }

}
