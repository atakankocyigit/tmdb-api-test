package com.tmdb.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static  org.hamcrest.core.Every.everyItem;

import java.util.List;

import org.testng.annotations.Test;

import com.tmdb.base.BaseServiceTest;
import com.tmdb.model.Genres;
import com.tmdb.spec.ResponseSpec;

import io.restassured.response.Response;

public class GenreTest extends BaseServiceTest {

	@Test
	public void getGenres() {
		//Get Tv Genres
		Response response = genreService.getGenres(ResponseSpec.getResponseSpec(200), "tv");
		List<Genres> genres = response.jsonPath().getList("genres", Genres.class);
		
		assertThat(genres, (everyItem(hasProperty("id"))));
		assertThat(genres, (everyItem(hasProperty("name"))));
		
		//Get Movie Genres
		response = genreService.getGenres(ResponseSpec.getResponseSpec(200), "movie");
		genres = response.jsonPath().getList("genres", Genres.class);
		
		assertThat(genres, (everyItem(hasProperty("id"))));
		assertThat(genres, (everyItem(hasProperty("name"))));
	}
}
