package studio.stilip.tensorkinopoisk.domain.entities.films

import studio.stilip.tensorkinopoisk.domain.entities.Actor

data class FilmInfo(
    val id: String,
    val year: Int,
    val rating: Double,
    val name: String,
    val poster: String,
    val genre: List<String>,
    val description: String,
    val actors: List<Actor>,
)
