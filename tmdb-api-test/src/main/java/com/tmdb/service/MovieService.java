package com.tmdb.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import com.tmdb.spec.RequestSpec;

public class MovieService extends RequestSpec{
	
	public int testMovieId = 278;
	public String testMovieName = "The Shawshank Redemption";
	public String testMovieStatus = "Released";
	private String requestBody = "{\"value\": 8.5}";
	
	public Response getTopRatedMovies(ResponseSpecification responseSpec) {
		return given()
					.spec(getRequestSpec())
					.queryParam("page", 1)
				.when()
					.get("/movie/top_rated")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response getMovieDetails(ResponseSpecification responseSpec) {
		return given()
					.spec(getRequestSpec())
					.pathParam("movieId", testMovieId)
				.when()
					.get("/movie/{movieId}")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response rateMovie(ResponseSpecification responseSpec, String session) {
		return given()
					.spec(getRequestSpec())
					.contentType(ContentType.JSON)
					.pathParam("movieId", testMovieId)
					.queryParam("session_id", session_id+session)
					.body(requestBody)
				.when()
					.post("/movie/{movieId}/rating")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response deleteRateMovie(ResponseSpecification responseSpec) {
		return given()
					.spec(getRequestSpec())
					.pathParam("movieId", testMovieId)
					.queryParam("session_id", session_id)
				.when()
					.delete("/movie/{movieId}/rating")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
}
