package studio.stilip.tensorkinopoisk.data.entities

data class FilmResponse(
    val id: Int,
    val externalId: ExternalId,
    val type: String?,
    val name: String?,
    val alternativeName: String?,
    val description: String?,
    val year: Int?,
    val poster: Poster?,
    val rating: Rating?,
    val votes: Votes?,
)

data class ExternalId(
    val tmdb: Int,
    val imdb: String
)

data class Poster(
    val url: String,
    val previewUrl: String
)

data class Rating(
    val tmdb: Double,
    val kp: Double,
    val imdb: Double,
)

data class Votes(
    val tmdb: Int,
    val kp: Int,
    val imdb: Int,
)
data class Genre(
    val name: String
)
