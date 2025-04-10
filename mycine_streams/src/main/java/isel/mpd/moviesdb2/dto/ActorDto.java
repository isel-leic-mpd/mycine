package isel.mpd.moviesdb2.dto;

import java.util.Optional;

public class ActorDto {
	private int id;
	private String name;
	private double popularity;
	private String character;

	@Override
	public String toString() {
		return "{ "
		+ "name=" + name
		+ ", id = " + id
		+ ", popularity=" + popularity
		+ ", character=" + character
		+ " }";
	}

	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public double getPopularity() {
		return popularity;
	}



}
