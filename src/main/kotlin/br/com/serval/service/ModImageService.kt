package br.com.serval.service

import br.com.serval.entity.ModImage

interface ModImageService {

    fun findAllModImages(): List<ModImage>
    fun findModImageById(id: Long): ModImage
    fun deleteModImageById(id: Long)
    fun saveModImages(modId: Long, modImageList: List<ModImage>): List<ModImage>
}