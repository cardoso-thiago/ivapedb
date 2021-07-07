package br.com.serval.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class BatteryDto(
    var id: Long? = null,
    var description: String
) : Serializable