package isel.leirt.mpd.moviesdb2_tests;

import isel.mpd.moviesdb2.MoviesDbWebApi;
import isel.mpd.moviesdb2.dto.*;
import isel.mpd.requests.HttpRequest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MoviesDbWebApiTests  {

	@Test
	public void getGenresTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(
				new HttpRequest()
		);
		final int EXPECTED_GENRES = 16;

		List<GenreDto> genres = api.getGenres();
		genres.forEach(System.out::println);
		assertEquals(EXPECTED_GENRES, genres.size());
	}
	
	@Test
	public void getAnimationTvSeriesTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());
		int animationGenreId = 16;
		List<TvSeriesDto> series =
			api.searchByGenreIds(1, List.of(animationGenreId));
		series.forEach(System.out::println);
		assertEquals(20, series.size());
	}


	@Test
	public void getActorsOfHomelandTest() {
		int  homelandId = 1407;
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());

		List<ActorDto> actors =
			api.tvSeriesActors(homelandId);
		System.out.println(actors.size());
		actors.forEach(System.out::println);
		assertEquals(7, actors.size());
	}

	@Test
	public void getRachelWoodSeriesTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());

		int rachelWoodId = 38940;
		List<TvSeriesDto> series =
			api.actorSeries(rachelWoodId);
		for(var m : series)
			System.out.println(m);
		assertEquals(28, series.size());
	}
	
	@Test
	public void recommendationsOfBreakingBadFisrtPageTest() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());
		int BREAKING_BAD_ID= 1396;
		int RECOMMENDATIONS_SIZE=20;
		
		List<TvSeriesDto> series = api.getTvSeriesRecommendations(1, BREAKING_BAD_ID);
		
		System.out.println("Recomendations size: " + series.size());
		for(var m : series)
			System.out.println(m);
		assertEquals(RECOMMENDATIONS_SIZE, series.size());
	}
	
	@Test
	public void getFirstPageOfTvSeriesNamedHomeLand() {
		MoviesDbWebApi api = new MoviesDbWebApi(new HttpRequest());

		List<TvSeriesDto> series = api.searchByName(1,"Homeland");

		for(var m : series)
			System.out.println(m);
		assertEquals(17, series.size());
	}
}
