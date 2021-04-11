package br.com.celfons.integration.response

data class QueryResponse(
    val row: Row
) {

    data class Row(
        val columns: ArrayList<String>
    )

}
