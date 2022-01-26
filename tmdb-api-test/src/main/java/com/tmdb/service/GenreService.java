package com.tmdb.service;

import static io.restassured.RestAssured.given;

import com.tmdb.spec.RequestSpec;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class GenreService extends RequestSpec {
	
	public Response getGenres(ResponseSpecification responseSpec, String type) {
		return given()
					.spec(getRequestSpec())
				.when()
					.get("/genre/"+ type + "/list")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
}
