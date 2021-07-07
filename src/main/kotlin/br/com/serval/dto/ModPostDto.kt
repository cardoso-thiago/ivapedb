package br.com.serval.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ModPostDto(
    var id: Long? = null,
    val name: String,
    val dimensions: String,
    val weight: String,
    val capacity: String,
    val outputWattage: String,
    val display: String,
    val coil: String,
    val brandId: Long,
    val batteryId: Long,
    val chargingTypeId: Long
) : Serializable