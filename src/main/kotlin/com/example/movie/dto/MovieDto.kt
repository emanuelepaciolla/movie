package com.example.movie.dto

import java.time.LocalDate

data class MovieDto(val name: String,
                    val date: LocalDate,
                    val author: String,
                    val actors: List<String>) {
}