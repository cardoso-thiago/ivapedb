package br.com.serval.service

import br.com.serval.entity.Brand

interface BrandService {

    fun findAllBrands(): List<Brand>
    fun findBrandById(id: Long): Brand
    fun deleteBrandById(id: Long)
    fun saveBrand(brand: Brand): Brand
}