package br.com.celfons.utils

import java.lang.RuntimeException

data class BusinessException(
    override val message: String? = null
): RuntimeException(message)
