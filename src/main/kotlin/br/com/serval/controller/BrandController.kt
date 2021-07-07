package br.com.serval.controller

import br.com.serval.dto.BrandDto
import br.com.serval.mapper.DataMapper
import br.com.serval.service.BrandService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/brand")
class BrandController(private val brandService: BrandService, private val dataMapper: DataMapper) {

    @Cacheable(cacheNames = ["Brand"], key = "#root.method.name")
    @GetMapping
    fun findAllBrands(): List<BrandDto> {
        val allBrands = brandService.findAllBrands()
        return dataMapper.brandToBrandDto(allBrands)
    }

    @Cacheable(cacheNames = ["Brand"], key = "#id")
    @GetMapping("/{id}")
    fun findBrandById(@PathVariable("id") id: Long): BrandDto {
        val brand = brandService.findBrandById(id)
        return dataMapper.brandToBrandDto(brand)
    }

    @CacheEvict(cacheNames = ["Brand"], allEntries = true)
    @DeleteMapping("/{id}")
    fun deleteBrandById(@PathVariable("id") id: Long) {
        brandService.deleteBrandById(id)
    }

    @CacheEvict(cacheNames = ["Brand"], allEntries = true)
    @PostMapping
    fun saveBrand(@RequestBody brandDto: BrandDto): BrandDto {
        val brand = dataMapper.brandDtoToBrand(brandDto)
        val savedBrand = brandService.saveBrand(brand)
        return dataMapper.brandToBrandDto(savedBrand)
    }
}