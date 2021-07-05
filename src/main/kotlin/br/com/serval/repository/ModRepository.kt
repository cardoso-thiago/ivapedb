package br.com.serval.repository

import br.com.serval.document.Mod
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ModRepository : ReactiveMongoRepository<Mod, String>