package br.com.serval.repository

import br.com.serval.entity.Brand
import org.springframework.data.repository.CrudRepository

interface BrandRepository : CrudRepository<Brand, Long>