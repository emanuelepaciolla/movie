package com.example.movie.service

import com.example.movie.dto.MovieDto
import com.example.movie.dto.MovieMapper
import com.example.movie.entity.Movie
import com.example.movie.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService {
    val movieRepository : MovieRepository
    val movieMapper : MovieMapper

    constructor(movieRepository: MovieRepository, movieMapper: MovieMapper){
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper
    }

    fun addMovie(movieDto: MovieDto){
        movieRepository.insert(movieMapper.fromMovieDtoToMovie(movieDto))
    }

}