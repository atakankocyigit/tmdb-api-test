package com.tmdb.service;

import static io.restassured.RestAssured.given;

import com.tmdb.spec.RequestSpec;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ListService extends RequestSpec {
	
	private String requestBody = "{\r\n"
			+ "  \"name\": \"super list.\",\r\n"
			+ "  \"description\": \"awesome list.\",\r\n"
			+ "  \"language\": \"en\"\r\n"
			+ "}";
	
	private String requestBodyMedia = "{\"media_id\": 278}";
	
	public Response createList(ResponseSpecification responseSpec) {

		return given()
					.spec(getRequestSpec())
					.header("Content-Type", "application/json;charset=utf-8")
					.body(requestBody)
					.queryParam("session_id", session_id)
				.when()
					.post("/list")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response addMovieToList(ResponseSpecification responseSpec, int listId) {
		return given()
					.spec(getRequestSpec())
					.header("Content-Type", "application/json;charset=utf-8")
					.pathParam("listId", listId)
					.queryParam("session_id", session_id)
					.body(requestBodyMedia)
				.when()
					.post("/list/{listId}/add_item")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	
	public Response removeMovieFromList(ResponseSpecification responseSpec, int listId) {
		return given()
					.spec(getRequestSpec())
					.header("Content-Type", "application/json;charset=utf-8")
					.pathParam("listId", listId)
					.queryParam("session_id", session_id)
					.body(requestBodyMedia)
				.when()
					.post("/list/{listId}/remove_item")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	/*
	public Response deleteList(ResponseSpecification responseSpec, int listId) {
		return given()
					.spec(getRequestSpec())
					.pathParam("listId", listId)
					.queryParam("session_id", session_id)
				.when()
					.delete("/list/{listId}")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
	*/
}
