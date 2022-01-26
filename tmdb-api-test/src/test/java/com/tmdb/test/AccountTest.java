package com.tmdb.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.tmdb.base.BaseServiceTest;
import com.tmdb.spec.ResponseSpec;

import io.restassured.response.Response;

public class AccountTest extends BaseServiceTest{
	
	private int accountId;
	@Test(priority=1)
	public void getAccountDetails() {
		Response response = accountService.getAccountDetails(ResponseSpec.getResponseSpec(200));
		assertThat(response.path("username"), is(equalTo(accountService.userName)));
		accountId = response.body().path("id");
	}
	
	@Test(priority=2)
	public void addToWatchList() {
		Response response = accountService.addToWatchList(ResponseSpec.getResponseSpec(201), accountId);
		assertThat(response.path("status_message").toString().toLowerCase(), is(containsString("success")));
	}
	
	@Test(priority=2)
	public void addToFavorites() {
		Response response = accountService.addToFavorites(ResponseSpec.getResponseSpec(201) ,accountId);
		assertThat(response.path("status_message").toString().toLowerCase(), is(containsString("success")));
	}
	
	@Test(priority=3)
	public void getMovieWatchList() {
		Response response = accountService.getMovieWatchList(ResponseSpec.getResponseSpec(200), accountId);
		assertThat(response.body().path("results.id"), hasItem(accountService.requestBodyWatchList.get("media_id")));
		assertThat(response.body().path("results.original_title"), hasItem("Star Wars"));
		assertThat(response.body().path("results.title"), hasItem("Star Wars"));
	}
	
	@Test(priority=3)
	public void getFavoriteMovies() {
		Response response = accountService.getFavoriteMovies(ResponseSpec.getResponseSpec(200), accountId);
		assertThat(response.body().path("results.id"), hasItem(accountService.requestBodyFavorites.get("media_id")));
		assertThat(response.body().path("results.original_title"), hasItem("Star Wars"));
		assertThat(response.body().path("results.title"), hasItem("Star Wars"));
	}
}
