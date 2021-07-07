package br.com.serval.service

import br.com.serval.entity.Battery

interface BatteryService {

    fun findAllBatteries(): List<Battery>
    fun findBatteryById(id: Long): Battery
    fun deleteBatteryById(id: Long)
    fun saveBattery(battery: Battery): Battery
}