package com.example.movie.repository

import com.example.movie.entity.Movie
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : MongoRepository<Movie, Long> {
}