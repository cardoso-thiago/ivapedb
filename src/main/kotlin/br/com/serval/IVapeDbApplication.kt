package br.com.serval

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class IVapeDbApplication

fun main(args: Array<String>) {
    runApplication<IVapeDbApplication>(*args)
}
