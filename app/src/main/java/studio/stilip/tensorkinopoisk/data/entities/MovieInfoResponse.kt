package studio.stilip.tensorkinopoisk.data.entities

data class MovieInfoResponse(
    val id: Int,
    val name: String?,
    val alternativeName: String?,
    val description: String?,
    val year: Int?,
    val poster: Poster?,
    val rating: Rating?,
    val genres: List<Genre>?,
    val persons: List<Person>?,
)
