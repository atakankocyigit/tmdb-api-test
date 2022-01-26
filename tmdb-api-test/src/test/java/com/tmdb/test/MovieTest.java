package com.tmdb.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.tmdb.base.BaseServiceTest;
import com.tmdb.spec.ResponseSpec;

import io.restassured.response.Response;

public class MovieTest extends BaseServiceTest{

	@Test
	public void topRatedMovies() {
		Response response = movieService.getTopRatedMovies(ResponseSpec.getResponseSpec(200));
		assertThat(response.path("results.id"), hasItem(movieService.testMovieId));
	}
	
	@Test
	public void getMovieDetails() {
		Response res = movieService.getMovieDetails(ResponseSpec.getResponseSpec(200));
		assertThat(res.jsonPath().get("id"), is(equalTo(movieService.testMovieId)));
		assertThat(res.body().path("original_title").toString().toLowerCase(), is(equalTo(movieService.testMovieName.toLowerCase())));
		assertThat(res.body().path("status").toString().toLowerCase(), is((movieService.testMovieStatus.toLowerCase())));
	}
	
	@Test
	public void negativeRateMovie() {
		Response res = movieService.rateMovie(ResponseSpec.getResponseSpec(401), "87596425785");
		assertThat(res.jsonPath().get("success"), is(equalTo(false)));
		assertThat(res.jsonPath().get("status_message").toString().toLowerCase(), is(containsString("authentication failed")));
	}
	
	@Test
	public void positiveRateMovie() {
		Response res = movieService.rateMovie(ResponseSpec.getResponseSpec(201), "");
		assertThat(res.jsonPath().get("status_message").toString().toLowerCase(), is(containsString("success")));
	}
	
	@Test
	public void deleteRateMovie() {
		Response res = movieService.deleteRateMovie(ResponseSpec.getResponseSpec(200));
		assertThat(res.path("status_message").toString().toLowerCase(), is(containsString("deleted successfully")));
	}
}
