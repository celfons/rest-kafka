package br.com.celfons.service

import br.com.celfons.events.CreatedUserEvent
import br.com.celfons.repository.UserRepository
import br.com.celfons.entity.UserEntity
import br.com.celfons.events.UpdatedUserEvent
import br.com.celfons.events.UserEvent
import br.com.celfons.utils.BusinessException
import org.springframework.stereotype.Service

@Service
class ProcessorServiceImpl(
    val repository: UserRepository
) : ProcessorService {

    override fun handler(event: CreatedUserEvent) = repository.save(UserEntity(event.id, event.name)).run { event }

    override fun handler(event: UpdatedUserEvent) = repository.findById(event.id).ifPresent{ user ->
        run { repository.save(user.copy(name = event.name)) }
    }.run { event }

}
