package br.com.serval.service

import br.com.serval.entity.ChargingType

interface ChargingTypeService {

    fun findAllChargingTypes(): List<ChargingType>
    fun findChargingTypeById(id: Long): ChargingType
    fun deleteChargingTypeById(id: Long)
    fun saveChargingType(chargingType: ChargingType): ChargingType
}