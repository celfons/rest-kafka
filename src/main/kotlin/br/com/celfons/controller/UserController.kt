package br.com.celfons.controller

import br.com.celfons.controller.request.UserRequest
import br.com.celfons.controller.response.UserResponse
import br.com.celfons.producer.KafkaProducer
import br.com.celfons.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/"])
class UserController(
    private val service: UserService,
    private val producer: KafkaProducer
) {

    @PostMapping
    fun create(@RequestBody request: UserRequest)= producer.create(request)

    @GetMapping
    fun findAll(): List<UserResponse> = service.findAll()

}
