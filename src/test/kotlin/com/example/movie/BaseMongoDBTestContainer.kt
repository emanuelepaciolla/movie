package com.example.movie

import com.mongodb.MongoClientSettings
import com.mongodb.kotlin.client.MongoClient
import com.mongodb.kotlin.client.MongoDatabase
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
abstract class BaseMongoDBTestContainer {

    companion object{

        @Container
        private val mongoDbContainer = MongoDBContainer("mongo:latest").withExposedPorts(27017)

        lateinit var database: MongoDatabase

        @JvmStatic
        @BeforeAll
        fun setup(){
            if (!mongoDbContainer.isRunning) mongoDbContainer.start()

            database = database()
        }

        private fun database(): MongoDatabase{
            val connectionString = "mongodb://${mongoDbContainer.host}:${mongoDbContainer.getMappedPort(27017)}"
            val mongoClient = MongoClient.create(connectionString)

            val codecRegistry: CodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            )
            return mongoClient.getDatabase("test-db").withCodecRegistry(codecRegistry)
        }


        @JvmStatic
        @AfterAll
        fun tearDown(){
            if(mongoDbContainer.isRunning) mongoDbContainer.stop()
        }
    }

}