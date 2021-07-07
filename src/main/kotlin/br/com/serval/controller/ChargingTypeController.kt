package br.com.serval.controller

import br.com.serval.dto.ChargingTypeDto
import br.com.serval.mapper.DataMapper
import br.com.serval.service.ChargingTypeService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/charging_type")
class ChargingTypeController(private val chargingTypeService: ChargingTypeService, private val dataMapper: DataMapper) {

    @Cacheable(cacheNames = ["ChargingType"], key = "#root.method.name")
    @GetMapping
    fun findAllChargingTypes(): List<ChargingTypeDto> {
        val allChargingTypes = chargingTypeService.findAllChargingTypes()
        return dataMapper.chargingTypeToChargingTypeDto(allChargingTypes)
    }

    @Cacheable(cacheNames = ["ChargingType"], key = "#id")
    @GetMapping("/{id}")
    fun findChargingTypeById(@PathVariable("id") id: Long): ChargingTypeDto {
        val chargingType = chargingTypeService.findChargingTypeById(id)
        return dataMapper.chargingTypeToChargingTypeDto(chargingType)
    }

    @CacheEvict(cacheNames = ["ChargingType"], allEntries = true)
    @DeleteMapping("/{id}")
    fun deleteChargingTypeById(@PathVariable("id") id: Long) {
        chargingTypeService.deleteChargingTypeById(id)
    }

    @CacheEvict(cacheNames = ["ChargingType"], allEntries = true)
    @PostMapping
    fun saveChargingType(@RequestBody chargingTypeDto: ChargingTypeDto): ChargingTypeDto {
        val chargingType = dataMapper.chargingTypeDtoToChargingType(chargingTypeDto)
        val savedChargingType = chargingTypeService.saveChargingType(chargingType)
        return dataMapper.chargingTypeToChargingTypeDto(savedChargingType)
    }
}