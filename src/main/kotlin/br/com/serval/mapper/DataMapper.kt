package br.com.serval.mapper

import br.com.serval.dto.*
import br.com.serval.entity.*
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface DataMapper {

    fun modDtoToMod(modDto: ModDto): Mod
    fun modPostDtoToMod(modPostDto: ModPostDto): Mod
    fun modToModDto(mod: Mod): ModDto
    fun modToModDto(modList: List<Mod>): List<ModDto>

    fun batteryDtoToBattery(batteryDto: BatteryDto): Battery
    fun batteryToBatteryDto(battery: Battery): BatteryDto
    fun batteryToBatteryDto(batteryList: List<Battery>): List<BatteryDto>

    fun brandDtoToBrand(brandDto: BrandDto): Brand
    fun brandToBrandDto(brand: Brand): BrandDto
    fun brandToBrandDto(brandList: List<Brand>): List<BrandDto>

    fun chargingTypeDtoToChargingType(chargingTypeDto: ChargingTypeDto): ChargingType
    fun chargingTypeToChargingTypeDto(chargingType: ChargingType): ChargingTypeDto
    fun chargingTypeToChargingTypeDto(chargingTypeList: List<ChargingType>): List<ChargingTypeDto>

    fun modImageDtoToModImage(modImageDto: ModImageDto): ModImage
    fun modImageDtoToModImage(modImageDto: List<ModImageDto>): List<ModImage>

    @Mapping(source = "mod.id", target = "modId")
    fun modImageToModImageDto(modImage: ModImage): ModImageDto
    fun modImageToModImageDto(modImageList: List<ModImage>): List<ModImageDto>
}