package br.com.serval.repository

import br.com.serval.entity.Battery
import org.springframework.data.repository.CrudRepository

interface BatteryRepository : CrudRepository<Battery, Long>