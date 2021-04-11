package br.com.celfons.integration.request

import java.util.Properties

data class QueryRequest(
    val ksql: String,
    val streamsProperties: Properties
)
