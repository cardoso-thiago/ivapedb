package br.com.serval.configuration

import br.com.serval.repository.ModRepository
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = [ModRepository::class])
class MongoConfiguration : AbstractReactiveMongoConfiguration() {

    override fun getDatabaseName() = "ivapedb"

    @Bean
    fun mongoClient(): MongoClient {
        val mongoDbHost = "localhost"
        val mongoDbPort = 27017
        val connectionString = ConnectionString("mongodb://$mongoDbHost:$mongoDbPort/$databaseName")
        val mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build()

        return MongoClients.create(mongoClientSettings)
    }

    override fun reactiveMongoClient() = mongoClient()

    override fun autoIndexCreation() = true
}