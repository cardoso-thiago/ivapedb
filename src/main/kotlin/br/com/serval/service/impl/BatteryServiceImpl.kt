package br.com.serval.service.impl

import br.com.serval.entity.Battery
import br.com.serval.repository.BatteryRepository
import br.com.serval.service.BatteryService
import org.springframework.stereotype.Service

@Service
class BatteryServiceImpl(private val batteryRepository: BatteryRepository) : BatteryService {

    override fun findAllBatteries() = batteryRepository.findAll().toList()

    override fun findBatteryById(id: Long) = batteryRepository.findById(id).get()

    override fun deleteBatteryById(id: Long) = batteryRepository.deleteById(id)

    override fun saveBattery(battery: Battery) = batteryRepository.save(battery)
}