package br.com.serval.service.impl

import br.com.serval.entity.ModImage
import br.com.serval.repository.ModImageRepository
import br.com.serval.service.ModImageService
import br.com.serval.service.ModService
import org.springframework.stereotype.Service

@Service
class ModImageServiceImpl(
    private val modImageRepository: ModImageRepository,
    private val modService: ModService
) : ModImageService {

    override fun findAllModImages() = modImageRepository.findAll().toList()

    override fun findModImageById(id: Long) = modImageRepository.findById(id).get()

    override fun deleteModImageById(id: Long) = modImageRepository.deleteById(id)

    override fun saveModImages(modId: Long, modImageList: List<ModImage>): List<ModImage> {
        for (modImage in modImageList) {
            val mod = modService.findModById(modId)
            modImage.mod = mod
        }
        return modImageRepository.saveAll(modImageList).toList()
    }
}