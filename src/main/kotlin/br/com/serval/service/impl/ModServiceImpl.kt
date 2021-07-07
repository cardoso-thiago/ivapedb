package br.com.serval.service.impl

import br.com.serval.entity.Mod
import br.com.serval.repository.ModRepository
import br.com.serval.service.BatteryService
import br.com.serval.service.BrandService
import br.com.serval.service.ChargingTypeService
import br.com.serval.service.ModService
import org.springframework.stereotype.Service

@Service
class ModServiceImpl(
    private val modRepository: ModRepository,
    private val brandService: BrandService,
    private val batteryService: BatteryService,
    private val chargingTypeService: ChargingTypeService
) : ModService {

    override fun findAllMods() = modRepository.findAll().toList()

    override fun findModById(id: Long) = modRepository.findById(id).get()

    override fun deleteModById(id: Long) = modRepository.deleteById(id)

    override fun saveMod(brandId: Long, batteryId: Long, chargingTypeId: Long, mod: Mod): Mod {
        val brand = brandService.findBrandById(brandId)
        val battery = batteryService.findBatteryById(batteryId)
        val chargingType = chargingTypeService.findChargingTypeById(chargingTypeId)
        mod.brand = brand
        mod.battery = battery
        mod.chargingType = chargingType
        return modRepository.save(mod)
    }
}