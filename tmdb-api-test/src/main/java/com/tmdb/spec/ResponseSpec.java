package com.tmdb.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
	public static ResponseSpecification getResponseSpec(int statusCode) {
		return new ResponseSpecBuilder()
							.expectStatusCode(statusCode)
							.log(LogDetail.ALL)
							.build();
	}
}
