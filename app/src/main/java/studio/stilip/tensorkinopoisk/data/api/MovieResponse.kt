package studio.stilip.tensorkinopoisk.data.api

data class MovieResponse(
    val id: Int,
    val externalId: ExternalId,
    val type: String?,
    val name: String?,
    val alternativeName: String?,
    val description: String?,
    val slogan: String?,
    val year: Int?,
    val poster: Poster?,
    val rating: Rating?,
    val votes: Votes?,
    val videos: Videos?,
    val budget: Budget?,
    val fees: Fees?,
    val distributors: Distributors?,
    val premiere: Premiere?,
    val images: Images?,
    val status: String?,
    val movieLength: Int?,
    val productionCompanies: List<ProductionCompany>?,
    val spokenLanguages: List<SpokenLanguage>?,
    val facts: List<Fact>?,
    val genres: List<Genre>?,
    val countries: List<Country>?,
    val seasonsInfo: List<Any>?,
    val persons: List<Person>?,
    val lists: List<Any>?
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

data class Videos(
    val trailers: List<Trailer>,
    val teasers: List<Teaser>,
)

data class Trailer(
    val _id: String,
    val url: String,
    val name: String,
    val site: String,
    val size: Int,
    val type: String
)

class Teaser(

)

data class Budget(
    val value: Long,
    val currency: String
)

data class Fees(
    val world: World,
    val usa: USA,
    val russia: Russia
)

data class World(val value: Long, val currency: String)
data class USA(val value: Long, val currency: String)
data class Russia(val value: Long, val currency: String)
data class Distributors(
    val distributor: String,
    val distributorRelease: String
)

data class Premiere(
    val country: String,
    val world: String,
    val russia: String,
    val bluray: String,
    val dvd: String
)

data class Images(
    val postersCount: Int,
    val backdropsCount: Int,
    val framesCount: Int
)

data class ProductionCompany(
    val name: String,
    val url: String,
    val previewUrl: String
)

data class SpokenLanguage(
    val name: String,
    val nameEn: String
)

data class Fact(
    val value: String
)

data class Genre(
    val name: String
)

data class Country(val name: String)
data class Person(
    val id: Int,
    val name: String,
    val enName: String,
    val photo: String,
    val enProfession: String
)