package studio.stilip.tensorkinopoisk.data.repositories

import io.reactivex.Completable
import io.reactivex.Single
import studio.stilip.tensorkinopoisk.data.api.RetrofitServiceMovie
import studio.stilip.tensorkinopoisk.data.dao.MovieForDBDao
import studio.stilip.tensorkinopoisk.data.database.MovieDatabase
import studio.stilip.tensorkinopoisk.data.dto.*
import studio.stilip.tensorkinopoisk.domain.entities.films.Film
import studio.stilip.tensorkinopoisk.domain.entities.MovieInfo
import studio.stilip.tensorkinopoisk.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitServiceMovie,
    private val movieDao: MovieForDBDao
) :
    MovieRepository {

    override fun getFilmsInfo(): Single<List<Film>> {

        return retrofitService.getFilms()
            .map { list ->
                list.docs.map { m -> m.toFilmDomain() }
            }
    }

    override fun getFilmsByName(name: String): Single<List<Film>> {
        return retrofitService.getFilmsByName(name)
            .map { list ->
                list.docs.map { m -> m.toFilmDomain() }
            }
    }

    override fun getFilmInfoById(id: String): Single<MovieInfo> {
        return retrofitService.getMovie(id).map { m -> m.toDomain() }
    }

    override fun addFilmByIdToFavorite(id: String): Boolean {
        return true
        TODO("Not yet implemented")
    }

    override fun removeFilmByIdToFavorite(id: String): Boolean {
        return true
        TODO("Not yet implemented")
    }

    override fun getSeriesInfo(): Single<List<Film>> {
        return retrofitService.getSeries()
            .map { list ->
                list.docs.map { m -> m.toFilmDomain() }
            }
    }

    override fun getSeriesByName(name: String): Single<List<Film>> {
        return retrofitService.getSeriesByName(name)
            .map { list -> list.docs.map { m -> m.toFilmDomain() } }
    }

    override fun setMovieToDB(movie: MovieInfo): Completable {
        return movieDao.insertMovie(movie.toDB())
    }

    override fun deleteMovieFromDB(movie: MovieInfo): Completable {
        return movieDao.deleteMovie(movie.toDB())
    }

    override fun getMovieByIdFromDB(id: String): Single<MovieInfo> {
        return movieDao.getMovieById(id).map { movie -> movie.toMovieInfo() }
    }

    override fun getAllMoviesFromDB(): Single<List<Film>> {
        return movieDao.getAllMovies().map { list ->
            list.map { movie -> movie.toFilm() }
        }
    }
}