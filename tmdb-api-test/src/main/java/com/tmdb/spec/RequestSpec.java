package com.tmdb.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.DecoderConfig;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	private static final String baseUri = "https://api.themoviedb.org";
	private static final String basePath = "/3";
	private static final String api_key = "your_api_key";
	protected static final String session_id = "your_session_id";
	public final String userName = "your_username";
	
	public static RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder()
						.setBaseUri(baseUri)
						.setBasePath(basePath)
						.addQueryParam("api_key", api_key)
						.setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
						.setConfig(RestAssuredConfig.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")))
						.log(LogDetail.ALL)
						.build();
	}
}
