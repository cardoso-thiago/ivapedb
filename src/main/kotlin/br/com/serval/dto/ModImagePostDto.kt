package br.com.serval.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ModImagePostDto(
    var modId: Long,
    var modImageList: List<ModImageDto>
) : Serializable