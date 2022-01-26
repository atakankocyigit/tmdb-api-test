package com.tmdb.service;

import com.tmdb.spec.RequestSpec;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class AccountService extends RequestSpec{
	
	public HashMap<String, Object> requestBodyWatchList = new HashMap<String, Object>();
	public HashMap<String, Object> requestBodyFavorites = new HashMap<String, Object>();

	public Response getAccountDetails(ResponseSpecification responseSpec) {
		return given()
					.spec(getRequestSpec())
					.queryParam("session_id", session_id)
				.when()
					.get("/account")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response addToWatchList(ResponseSpecification responseSpec, int accountId) {
		requestBodyWatchList.put("media_type", "movie");
		requestBodyWatchList.put("media_id", 11);
		requestBodyWatchList.put("watchlist", true);
		
		return given()
					.spec(getRequestSpec())
					.queryParam("session_id", session_id)
					.pathParam("accountId", accountId)
					.contentType(ContentType.JSON)
					.body(requestBodyWatchList)
				.when()
					.post("/account/{accountId}/watchlist")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response getMovieWatchList(ResponseSpecification responseSpec, int accountId) {
		return given()
					.spec(getRequestSpec())
					.queryParam("session_id", session_id)
					.pathParam("accountId", accountId)
				.when()
					.get("account/{accountId}/watchlist/movies")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response addToFavorites(ResponseSpecification responseSpec, int accountId) {
		requestBodyFavorites.put("media_type", "movie");
		requestBodyFavorites.put("media_id", 11);
		requestBodyFavorites.put("favorite", true);
		
		return given()
				.spec(getRequestSpec())
				.queryParam("session_id", session_id)
				.pathParam("accountId", accountId)
				.body(requestBodyFavorites)
				.contentType(ContentType.JSON)
			.when()
				.post("/account/{accountId}/favorite")
			.then()
				.spec(responseSpec)
				.extract()
				.response();
	}
	
	public Response getFavoriteMovies(ResponseSpecification responseSpec, int accountId) {
		return given()
					.spec(getRequestSpec())
					.queryParam("session_id", session_id)
					.pathParam("accountId", accountId)
				.when()
					.get("/account/{accountId}/favorite/movies")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
}
