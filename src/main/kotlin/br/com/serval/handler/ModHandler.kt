package br.com.serval.handler

import br.com.serval.dto.ModDto
import br.com.serval.mapper.DataMapper
import br.com.serval.service.ModService
import com.fasterxml.jackson.core.type.TypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.net.URI

@Component
class ModHandler(private val modService: ModService, private val dataMapper: DataMapper) {

    fun findAllMods(request: ServerRequest): Mono<ServerResponse> {
        val allMods = modService.findAllMods()
        val allModsDto = allMods.map(dataMapper::modToModDto)
        return ServerResponse.ok().body(allModsDto, ModDto::class.java)
    }

    fun findMod(request: ServerRequest): Mono<ServerResponse> {
        val modId = request.pathVariable("id")
        val monoModType = object : TypeReference<Mono<ModDto>>() {}.javaClass
        val mod = modService.findModById(modId)
        val modDto = mod.map(dataMapper::modToModDto)
        return ServerResponse.ok().body(modDto, monoModType)
    }

    fun deleteMod(request: ServerRequest): Mono<ServerResponse> {
        val modId = request.pathVariable("id")
        return modService.deleteModById(modId).then(ServerResponse.ok().build())
    }

    fun saveMod(request: ServerRequest): Mono<ServerResponse> {
        val modDto = request.bodyToMono(ModDto::class.java)
        val mod = modDto.map(dataMapper::modDtoToMod)
        val savedMod = mod.flatMap(modService::saveMod)
        val savedModDto = savedMod.map(dataMapper::modToModDto)
        return ServerResponse.created(URI("")).body(savedModDto, ModDto::class.java)
    }
}