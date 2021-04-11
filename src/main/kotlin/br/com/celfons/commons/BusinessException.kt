package br.com.celfons.commons

import java.lang.RuntimeException

data class BusinessException(
    override val message: String? = null
): RuntimeException(message)
