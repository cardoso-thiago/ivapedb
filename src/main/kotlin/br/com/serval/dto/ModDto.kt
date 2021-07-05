package br.com.serval.dto

data class ModDto(
    var id: String? = null,
    val name: String,
    val dimensions: String,
    val weight: String,
    val brandId: String,
    val capacity: String,
    val charging: String,
    val batteryTypeId: String,
    val outputWattage: String,
    val display: String,
    val coil: String,
    val website: String,
    val images: List<String>
)