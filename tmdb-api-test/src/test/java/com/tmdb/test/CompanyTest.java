package com.tmdb.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.tmdb.base.BaseServiceTest;
import com.tmdb.model.Company;
import com.tmdb.spec.ResponseSpec;

import io.restassured.response.Response;

public class CompanyTest extends BaseServiceTest {

	@Test
	public void getCompanyDetails() {
		int companyId=34;
		Response response = companyService.getCompanyDetails(ResponseSpec.getResponseSpec(200), companyId);
		Company company = response.as(Company.class); 
		assertThat(company.getId(), is(equalTo(companyId)));
		assertThat(company.getName().toLowerCase(), is(equalTo("sony pictures")));
	}
}
