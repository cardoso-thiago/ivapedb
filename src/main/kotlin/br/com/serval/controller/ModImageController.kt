package br.com.serval.controller

import br.com.serval.dto.ModImageDto
import br.com.serval.dto.ModImagePostDto
import br.com.serval.mapper.DataMapper
import br.com.serval.service.ModImageService
import br.com.serval.service.ModService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/mod_image")
class ModImageController(
    private val modImageService: ModImageService,
    private val modService: ModService,
    private val dataMapper: DataMapper
) {

    @Cacheable(cacheNames = ["ModImage"], key = "#root.method.name")
    @GetMapping
    fun findAllModImages(): List<ModImageDto> {
        val allModImages = modImageService.findAllModImages()
        return dataMapper.modImageToModImageDto(allModImages)
    }

    @Cacheable(cacheNames = ["ModImage"], key = "#id")
    @GetMapping("/{id}")
    fun findModImageById(@PathVariable("id") id: Long): ModImageDto {
        val modImage = modImageService.findModImageById(id)
        return dataMapper.modImageToModImageDto(modImage)
    }

    @CacheEvict(cacheNames = ["ModImage"], allEntries = true)
    @DeleteMapping("/{id}")
    fun deleteModImageById(@PathVariable("id") id: Long) {
        modImageService.deleteModImageById(id)
    }

    @CacheEvict(cacheNames = ["ModImage"], allEntries = true)
    @PostMapping
    fun saveModImages(@RequestBody modImageDtoPost: ModImagePostDto): List<ModImageDto> {
        val modImageList = dataMapper.modImageDtoToModImage(modImageDtoPost.modImageList)
        val savedModList = modImageService.saveModImages(modImageDtoPost.modId, modImageList)
        return dataMapper.modImageToModImageDto(savedModList)
    }
}