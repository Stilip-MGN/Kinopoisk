package studio.stilip.tensorkinopoisk.data.entities


data class MovieResponse(
    val id: Int,
    val name: String?,
    val alternativeName: String?,
    val movieLength: Int?,
    val description: String?,
    val year: Int?,
    val poster: Poster?,
    val rating: Rating?,
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

data class Genre(
    val name: String
)
