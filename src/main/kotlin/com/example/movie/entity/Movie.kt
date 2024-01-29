package com.example.movie.entity

import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import java.time.LocalDate


data class Movie @BsonCreator constructor(@BsonId val id: String?,
                                          @BsonProperty("name") val name: String,
                                          @BsonProperty("date")val date: LocalDate,
                                          @BsonProperty("author")val author: String,
                                          @BsonProperty("actors")val actors: List<String>) {

}
