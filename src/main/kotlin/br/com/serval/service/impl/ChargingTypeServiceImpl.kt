package br.com.serval.service.impl

import br.com.serval.entity.ChargingType
import br.com.serval.repository.ChargingTypeRepository
import br.com.serval.service.ChargingTypeService
import org.springframework.stereotype.Service

@Service
class ChargingTypeServiceImpl(private val chargingTypeRepository: ChargingTypeRepository) : ChargingTypeService {

    override fun findAllChargingTypes() = chargingTypeRepository.findAll().toList()

    override fun findChargingTypeById(id: Long) = chargingTypeRepository.findById(id).get()

    override fun deleteChargingTypeById(id: Long) = chargingTypeRepository.deleteById(id)

    override fun saveChargingType(chargingType: ChargingType) = chargingTypeRepository.save(chargingType)
}