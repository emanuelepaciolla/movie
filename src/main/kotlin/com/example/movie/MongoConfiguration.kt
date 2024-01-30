package com.example.movie

import com.mongodb.kotlin.client.MongoClient
import com.mongodb.kotlin.client.MongoDatabase
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfiguration(@Value("\${spring.data.mongodb.host}") val uri: String,
        @Value("\${spring.data.mongodb.database}") val database: String) {
    @Bean
    fun mongoDatabase(): MongoDatabase {
        val mongoClient = MongoClient.create(uri)
        return mongoClient.getDatabase(database)
    }


}