package studio.stilip.tensorkinopoisk.data.dto

import studio.stilip.tensorkinopoisk.data.entities.*
import studio.stilip.tensorkinopoisk.domain.entities.Actor
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo

fun MovieResponse.toFilmDomain(): Film {

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
    )
}

fun MovieInfoResponse.toDomain(): MovieInfo {
    val rating =
        if (this.rating?.kp == 0.0) this.rating.imdb
        else this.rating?.kp
            ?: this.rating?.tmdb
            ?: 0.0

    fun Person.toDomain(): Actor =
        Actor(
            fullName = if (this.name.isNullOrEmpty()) this.enName ?: "" else this.name,
            urlPhoto = this.photo
        )


    return MovieInfo(
        id = this.id.toString(),
        year = this.year ?: 0,
        rating = rating,
        name = this.name ?: this.alternativeName ?: "",
        poster = this.poster?.url ?: "",
        genre = this.genres?.map { genre -> genre.name } ?: listOf(),
        actors = this.persons?.map { person -> person.toDomain() } ?: listOf(),
        description = this.description ?: ""
    )
}

fun MovieInfo.toDB(): MovieForDB =
    MovieForDB(
        id = this.id,
        name = name,
        description = description,
        year = year,
        poster = poster,
        rating = rating
    )

fun MovieForDB.toFilm(): Film =
    Film(
        id = this.id,
        year = this.year,
        rating = this.rating,
        title = this.name,
        poster = this.poster
    )


