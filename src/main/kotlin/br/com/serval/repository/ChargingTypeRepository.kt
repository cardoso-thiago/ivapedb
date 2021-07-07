package br.com.serval.repository

import br.com.serval.entity.ChargingType
import org.springframework.data.repository.CrudRepository

interface ChargingTypeRepository : CrudRepository<ChargingType, Long>