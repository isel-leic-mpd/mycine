package isel.mpd.moviesdb2.model;

import java.util.stream.Stream;

import static isel.mpd.Errors.TODO;

public class Genre {
	private int id;
	private String name;

	Stream<TvSeries> series;

	public Genre(int id, String name, Stream<TvSeries>  series) {
		this.id = id;
		this.name =  name;
		this.series = series;
	}

	public Stream<TvSeries> getSeries() {
		TODO("genre getSeries");
		return Stream.empty();
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "{ "
			+ "name = " + name
			+ ", id = " + id
			+ " }";
	}
}
