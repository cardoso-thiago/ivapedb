package br.com.serval.repository

import br.com.serval.entity.Mod
import org.springframework.data.repository.CrudRepository

interface ModRepository : CrudRepository<Mod, Long>