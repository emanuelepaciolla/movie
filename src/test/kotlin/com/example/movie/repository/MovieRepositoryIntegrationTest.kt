package com.example.movie.repository

import com.example.movie.BaseMongoDBTestContainer
import com.example.movie.entity.Movie
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class MovieRepositoryIntegrationTest : BaseMongoDBTestContainer() {

    private fun contents() = database.getCollection<Movie>("movie")
    private val repository = MovieRepositoryImpl(database)

    @Test
    fun findAllReturnsOnlyOneElement() {

        contents().insertOne(Movie(id = "1", name = "name", date = LocalDate.now(), author = "author", actors = emptyList()))

        val findAll = repository.findAll()

        Assertions.assertEquals(1, findAll.size)

    }

    @Test
    fun findAllReturnsOnlyZeroElement() {
        val findAll = repository.findAll()

        Assertions.assertEquals(0, findAll.size)

    }

    @Test
    fun insertAddElementToCollection() {
        repository.insert(
                Movie(id = "1",
                        name = "name",
                        date = LocalDate.now(),
                        author = "author",
                        actors = emptyList()))

        val findAll = repository.findAll()

        Assertions.assertEquals(1, findAll.size)

    }

}