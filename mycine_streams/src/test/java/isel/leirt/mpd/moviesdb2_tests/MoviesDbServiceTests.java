package isel.leirt.mpd.moviesdb2_tests;

import isel.mpd.moviesdb2.MoviesDbService;
import isel.mpd.moviesdb2.MoviesDbWebApi;
import isel.mpd.moviesdb2.model.Genre;
import isel.mpd.moviesdb2.model.TvSeries;
import isel.mpd.requests.CounterRequest;
import isel.mpd.requests.HttpRequest;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class MoviesDbServiceTests {

	@Test
	public void getGenresTest() {
		CounterRequest req = new CounterRequest( new HttpRequest() );
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));

		Stream<Genre> sgenres = serv.getGenres();
		assertEquals(0, req.getCount());

		List<Genre> genres = sgenres.collect(toList());
		genres.forEach(System.out::println);
		assertEquals(16, genres.size());
		assertEquals(1, req.getCount());
	}

	
	@Test
	public void getActionAndAdventureTvSeriesTest() {
		CounterRequest req = new CounterRequest( new HttpRequest() );
		int misteryGenreId = 9648;
		int crimeGenreId = 80;
		int maxSeries = 40;

		MoviesDbService serv =
			new MoviesDbService(
				new MoviesDbWebApi(
					req
				)
			);
		
		Stream<TvSeries> series =
			serv.searchByGenre(maxSeries, List.of(misteryGenreId, crimeGenreId) );

		assertEquals(0, req.getCount());
		System.out.println(series.count());

		assertEquals(2, req.getCount());

		Stream<TvSeries> firstTen =
				serv.searchByGenre(maxSeries, List.of(misteryGenreId, crimeGenreId))
				.limit(10);

		assertEquals(2, req.getCount());

		firstTen.forEach(movie -> {
			System.out.println(movie.getName() + " actors:");
			movie.getActors().forEach(System.out::println);
			System.out.println();
		});
		assertEquals(13, req.getCount());
	}

	@Test
	public void getActorsOfWestWorldMovieTest() {
		int westWorldMovieId = 63247; // WestWorld, 2020
		CounterRequest req = new CounterRequest(new HttpRequest());
		MoviesDbService serv =
			  new MoviesDbService(new MoviesDbWebApi(req));

		 

		var actorsList = serv.getTvSeriesActors(westWorldMovieId).toList();
		actorsList.forEach(System.out::println);
		assertEquals(2, req.getCount());
		assertEquals(7, actorsList.size());
		assertEquals(2, req.getCount());
	}

 

	@Test
	public void getRachelWoodMoviesTest() {
		CounterRequest req = new CounterRequest(new HttpRequest());
		MoviesDbService serv =
			new MoviesDbService(new MoviesDbWebApi(req));

		int rachelWoodId = 38940;
		Stream<TvSeries> moviesStream =
			serv.getActorTvSeries(rachelWoodId);
		assertEquals(0, req.getCount());

		var moviesList = moviesStream.collect(toList());

		moviesList.forEach(System.out::println);
		assertEquals(1, req.getCount());
		assertEquals(49, moviesList.size());
	}


}
