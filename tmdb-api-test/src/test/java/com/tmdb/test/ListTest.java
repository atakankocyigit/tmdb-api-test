package com.tmdb.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.tmdb.base.BaseServiceTest;
import com.tmdb.spec.ResponseSpec;

import io.restassured.response.Response;

public class ListTest extends BaseServiceTest{

	private int list_id;
	
	@Test(priority=1)
	public void createList() {
		Response response = listService.createList(ResponseSpec.getResponseSpec(201));
		assertThat(response.path("success"), is(equalTo(true)));
		assertThat(response.path("status_message"), is(containsString("created successfully")));
		list_id = response.path("list_id");
	}

	@Test(priority=2)
	public void addMovieToList() {
		Response response = listService.addMovieToList(ResponseSpec.getResponseSpec(201), list_id);
		assertThat(response.path("status_message"), is(containsString("updated successfully")));
	}

	@Test(priority=3)
	public void removeMovieFromList() {
		Response response = listService.removeMovieFromList(ResponseSpec.getResponseSpec(200), list_id);
		assertThat(response.path("status_message"), is(containsString("deleted successfully")));
	}
}
