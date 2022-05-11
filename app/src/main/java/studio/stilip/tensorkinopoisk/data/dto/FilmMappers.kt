package studio.stilip.tensorkinopoisk.data.dto

import studio.stilip.tensorkinopoisk.data.api.MovieResponse
import studio.stilip.tensorkinopoisk.data.entities.FilmEntityForApi
import studio.stilip.tensorkinopoisk.data.entities.FilmEntityForDB
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

fun MovieResponse.toDomain(): Film = Film(
    id = this.id.toString(),
    title = this.name ?: this.alternativeName ?: "",
    poster = this.poster?.previewUrl ?: "",
    genre = this.genres?.first()?.name ?: ""
)


