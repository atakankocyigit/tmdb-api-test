package com.tmdb.service;

import com.tmdb.spec.RequestSpec;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class CompanyService extends RequestSpec{
	
	public Response getCompanyDetails(ResponseSpecification responseSpec, int companyId) {
		return given()
					.spec(getRequestSpec())
					.pathParam("companyId", companyId)
				.when()
					.get("/company/{companyId}")
				.then()
					.spec(responseSpec)
					.extract()
					.response();
	}
}
