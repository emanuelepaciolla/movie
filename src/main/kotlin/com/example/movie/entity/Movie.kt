package com.example.movie.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
    data class Movie(@Id val id: Long,
                 val name: String,
                 val date: LocalDate,
                 val author: String,
                 val actors: List<String>) {

}


