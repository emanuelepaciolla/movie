package com.example.movie.dto

import com.example.movie.entity.Movie
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface MovieMapper {

    @Mapping(target = "id", ignore = true)
    fun fromMovieDtoToMovie(movieDto: MovieDto) : Movie

}