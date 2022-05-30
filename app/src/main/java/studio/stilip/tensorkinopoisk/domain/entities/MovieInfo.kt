package studio.stilip.tensorkinopoisk.domain.entities

data class MovieInfo(
    val id: String,
    val year: Int,
    val length: String,
    val rating: Double,
    val name: String,
    val poster: String,
    val genre: List<String>,
    val description: String,
    val actors: List<Actor>,
)
