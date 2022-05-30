package studio.stilip.tensorkinopoisk.domain.entities.films

data class Film(
    val id: String,
    val year: Int,
    val length: String,
    val rating: Double,
    val title: String,
    val poster: String,
)
