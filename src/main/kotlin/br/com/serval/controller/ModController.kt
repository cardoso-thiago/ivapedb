package br.com.serval.controller

import br.com.serval.dto.ModDto
import br.com.serval.dto.ModPostDto
import br.com.serval.mapper.DataMapper
import br.com.serval.service.ModService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/mod")
class ModController(private val modService: ModService, private val dataMapper: DataMapper) {

    @Cacheable(cacheNames = ["Mod"], key = "#root.method.name")
    @GetMapping
    fun findAllMods(): List<ModDto> {
        val allMods = modService.findAllMods()
        return dataMapper.modToModDto(allMods)
    }

    @Cacheable(cacheNames = ["Mod"], key = "#id")
    @GetMapping("/{id}")
    fun findModById(@PathVariable("id") id: Long): ModDto {
        val mod = modService.findModById(id)
        return dataMapper.modToModDto(mod)
    }

    @CacheEvict(cacheNames = ["Mod"], allEntries = true)
    @DeleteMapping("/{id}")
    fun deleteModById(@PathVariable("id") id: Long) {
        modService.deleteModById(id)
    }

    @CacheEvict(cacheNames = ["Mod"], allEntries = true)
    @PostMapping
    fun saveMod(@RequestBody modPostDto: ModPostDto): ModDto {
        val mod = dataMapper.modPostDtoToMod(modPostDto)
        val savedMod = modService.saveMod(modPostDto.brandId, modPostDto.batteryId, modPostDto.chargingTypeId, mod)
        return dataMapper.modToModDto(savedMod)
    }
}