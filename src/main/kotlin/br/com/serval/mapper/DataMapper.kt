package br.com.serval.mapper

import br.com.serval.document.Mod
import br.com.serval.dto.ModDto
import org.mapstruct.Mapper

@Mapper
interface DataMapper {

    fun modDtoToMod(modDto: ModDto): Mod
    fun modToModDto(Mod: Mod): ModDto
}