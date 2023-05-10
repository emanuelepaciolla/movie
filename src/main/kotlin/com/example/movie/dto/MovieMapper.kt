package com.example.movie.dto

import com.example.movie.dto.MovieDto
import com.example.movie.entity.Movie
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface MovieMapper {

    @Mapping(target = "id", ignore = true)
    fun fromMovieDtoToMovie(movieDto: MovieDto) : Movie

}