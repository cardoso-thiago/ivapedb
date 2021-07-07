package br.com.serval.service.impl

import br.com.serval.entity.Brand
import br.com.serval.repository.BrandRepository
import br.com.serval.service.BrandService
import org.springframework.stereotype.Service

@Service
class BrandServiceImpl(private val brandRepository: BrandRepository) : BrandService {

    override fun findAllBrands() = brandRepository.findAll().toList()

    override fun findBrandById(id: Long) = brandRepository.findById(id).get()

    override fun deleteBrandById(id: Long) = brandRepository.deleteById(id)

    override fun saveBrand(brand: Brand) = brandRepository.save(brand)
}