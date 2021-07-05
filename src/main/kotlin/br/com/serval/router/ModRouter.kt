package br.com.serval.router

import br.com.serval.handler.ModHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class ModRouter {

    @Bean
    fun route(modHandler: ModHandler) = router {
        ("/v1/mod").nest {
            GET("", modHandler::findAllMods)
            GET("/{id}", modHandler::findMod)
            DELETE("/{id}", modHandler::deleteMod)
            POST("", modHandler::saveMod)
        }
    }
}