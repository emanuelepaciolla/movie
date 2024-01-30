package com.example.movie.repository

import com.example.movie.entity.Movie
import com.mongodb.client.model.Filters
import com.mongodb.kotlin.client.MongoDatabase
import org.springframework.stereotype.Repository

@Repository
class MovieRepositoryImpl(private val database: MongoDatabase) : MovieRepository {

    private fun movieCollection() = database.getCollection<Movie>("movie")

    override fun insert(entity: Movie) {
        movieCollection().insertOne(entity)
    }

    override fun findAll() : List<Movie> {
        return movieCollection().find(Filters.empty()).toList()
    }

    override fun findOneById(id: String) : Movie? {
        return movieCollection().find(Filters.eq("id", id)).firstOrNull()
    }
}