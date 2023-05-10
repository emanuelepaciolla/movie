package com.example.movie.controller

import com.example.movie.dto.MovieDto
import com.example.movie.dto.MovieMapper
import com.example.movie.dto.MovieMapperImpl
import com.example.movie.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MovieController {

    constructor(movieService: MovieService, movieMapper: MovieMapperImpl){
        this.movieService = movieService
        this.movieMapper = movieMapper
    }

    val movieService : MovieService
    val movieMapper : MovieMapper

    @GetMapping("/hello")
    fun getFirstMapping() : ResponseEntity<String> {
        return ResponseEntity.of(Optional.of("Hello"));
    }

    @PostMapping("/movie")
    fun addFirstMovie(@RequestBody movie: MovieDto){
        movieService.addMovie(movie)
    }

}