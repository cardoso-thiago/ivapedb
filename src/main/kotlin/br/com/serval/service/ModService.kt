package br.com.serval.service

import br.com.serval.document.Mod
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ModService {

    fun findAllMods(): Flux<Mod>
    fun findModById(id: String): Mono<Mod>
    fun deleteModById(id: String): Mono<Void>
    fun saveMod(mod: Mod): Mono<Mod>
}