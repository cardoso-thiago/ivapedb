package br.com.serval.service.impl

import br.com.serval.document.Mod
import br.com.serval.repository.ModRepository
import br.com.serval.service.ModService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ModServiceImpl(private val modRepository: ModRepository) : ModService {

//    @Cacheable(cacheNames = ["Mod"], key = "#root.method.name")
    override fun findAllMods() = modRepository.findAll()

//    @Cacheable(cacheNames = ["Mod"], key = "#id")
    override fun findModById(id: String) = modRepository.findById(id)

//    @CacheEvict(cacheNames = ["Mod"], allEntries = true)
    override fun deleteModById(id: String) = modRepository.deleteById(id)

//    @CacheEvict(cacheNames = ["Mod"], allEntries = true)
    override fun saveMod(mod: Mod) = modRepository.save(mod)
}