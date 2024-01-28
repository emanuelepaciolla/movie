package com.example.movie.repository

interface BaseRepository<ENTITY> {

    fun insert(entity : ENTITY)
    fun findAll(): List<ENTITY>
    fun findOneById(id : String): ENTITY?

}