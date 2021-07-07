package br.com.serval.controller

import br.com.serval.dto.BatteryDto
import br.com.serval.mapper.DataMapper
import br.com.serval.service.BatteryService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/battery")
class BatteryController(private val batteryService: BatteryService, private val dataMapper: DataMapper) {

    @Cacheable(cacheNames = ["Battery"], key = "#root.method.name")
    @GetMapping
    fun findAllBatteries(): List<BatteryDto> {
        val allBatteries = batteryService.findAllBatteries()
        return dataMapper.batteryToBatteryDto(allBatteries)
    }

    @Cacheable(cacheNames = ["Battery"], key = "#id")
    @GetMapping("/{id}")
    fun findBatteryById(@PathVariable("id") id: Long): BatteryDto {
        val battery = batteryService.findBatteryById(id)
        return dataMapper.batteryToBatteryDto(battery)
    }

    @CacheEvict(cacheNames = ["Battery"], allEntries = true)
    @DeleteMapping("/{id}")
    fun deleteBatteryById(@PathVariable("id") id: Long) {
        batteryService.deleteBatteryById(id)
    }

    @CacheEvict(cacheNames = ["Battery"], allEntries = true)
    @PostMapping
    fun saveBattery(@RequestBody batteryDto: BatteryDto): BatteryDto {
        val battery = dataMapper.batteryDtoToBattery(batteryDto)
        val savedBattery = batteryService.saveBattery(battery)
        return dataMapper.batteryToBatteryDto(savedBattery)
    }
}