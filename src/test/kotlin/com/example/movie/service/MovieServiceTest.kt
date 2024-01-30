package com.example.movie.service

import com.example.movie.dto.MovieDto
import com.example.movie.dto.MovieMapperImpl
import com.example.movie.entity.Movie
import com.example.movie.repository.MovieRepository
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class MovieServiceTest {

    val movieRepository = mockk<MovieRepository>(relaxed = true)
    val movieMapper = MovieMapperImpl()
    val movieService = MovieService(movieRepository = movieRepository,
            movieMapper = movieMapper)

    @Test
    fun addMovieShouldAddNewMovie(){
        val movieDto = MovieDto(name = "movie", date = LocalDate.now(), author = "author",
                actors = emptyList())

        val fromMovieDtoToMovie = movieMapper.fromMovieDtoToMovie(movieDto)

        movieService.addMovie(movieDto)

        val slot = slot<Movie>()
        verify { movieRepository.insert(capture(slot)) }
        Assertions.assertEquals(fromMovieDtoToMovie, slot.captured)
    }

}