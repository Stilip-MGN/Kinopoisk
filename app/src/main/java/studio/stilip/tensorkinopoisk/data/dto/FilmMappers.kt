package studio.stilip.tensorkinopoisk.data.dto

import studio.stilip.tensorkinopoisk.data.entities.FilmEntityForApi
import studio.stilip.tensorkinopoisk.data.entities.FilmEntityForDB
import studio.stilip.tensorkinopoisk.data.entities.FilmResponse
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import timber.log.Timber

/*fun Film.toDB(): FilmEntityForDB =
    FilmEntityForDB(
        id = this.id,
        title = this.title,
        poster = this.poster,
        genre = this.genre
    )

fun FilmEntityForDB.toDomain():Film =
    Film(
        id = this.id,
        title = this.title,
        poster = this.poster,
        genre = this.genre
    )

fun FilmEntityForApi.toDomain():Film =
    Film(
        id = this.id,
        title = this.title,
        poster = this.poster,
        genre = this.genre
    )

 */

fun FilmResponse.toDomain(): Film {

    val rating =
        if (this.rating?.kp == 0.0) this.rating.imdb
        else this.rating?.kp
            ?: this.rating?.tmdb
            ?: 0.0

    return Film(
        id = this.id.toString(),
        year = this.year ?: 0,
        rating = rating,
        title = this.name ?: this.alternativeName ?: "",
        poster = this.poster?.previewUrl ?: "",
        genre = this.genres?.first()?.name ?: ""
    )
}

