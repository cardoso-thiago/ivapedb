package br.com.serval.service

import br.com.serval.entity.Mod

interface ModService {

    fun findAllMods(): List<Mod>
    fun findModById(id: Long): Mod
    fun deleteModById(id: Long)
    fun saveMod(brandId: Long, batteryId: Long, chargingTypeId: Long, mod: Mod): Mod
}