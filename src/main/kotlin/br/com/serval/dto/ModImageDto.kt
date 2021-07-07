package br.com.serval.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ModImageDto(
    var id: Long? = null,
    val url: String,
    val color: String,
    val colorBackground: String,
    val modId: Long? = null
) : Serializable