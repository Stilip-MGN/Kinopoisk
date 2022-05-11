package studio.stilip.tensorkinopoisk.data.api

import studio.stilip.tensorkinopoisk.data.entities.FilmResponse

data class FilmsListResponse(
    val docs: List<FilmResponse>
)