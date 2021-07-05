package br.com.serval.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document
data class Mod(
    @Id
    var id: String? = null,
    @Indexed(unique = true)
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