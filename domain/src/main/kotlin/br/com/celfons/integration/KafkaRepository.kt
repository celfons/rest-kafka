package br.com.celfons.integration

import br.com.celfons.integration.request.QueryRequest
import br.com.celfons.integration.response.QueryResponse
import feign.Headers
import feign.RequestLine

interface KafkaRepository {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /query")
    fun query(request: QueryRequest): QueryResponse

}