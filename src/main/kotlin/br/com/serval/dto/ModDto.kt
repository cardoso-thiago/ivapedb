package br.com.serval.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ModDto(
    var id: Long? = null,
    val name: String,
    val dimensions: String,
    val weight: String,
    val capacity: String,
    val outputWattage: String,
    val display: String,
    val brand: BrandDto? = null,
    val battery: BatteryDto? = null,
    val chargingType: ChargingTypeDto? = null,
    val modImages: List<ModImageDto>? = null
) : Serializable