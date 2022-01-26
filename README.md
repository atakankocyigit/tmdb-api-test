# TMDB API

The project was created using the API of the TMDB page. You can find the description of the functions and their usage at https://developers.themoviedb.org/3/getting-started/introduction.

In order to use the project, you must be a member of the TMDB page and then the authorization procedures must be done. After getting the API key from the settings page, session_id should be obtained from https://developers.themoviedb.org/3/authentication/how-do-i-generate-a-session-id page.

API key, session_id and username must be written into the variables in the file in \src\main\java\com\tmdb\spec\RequestSpec.java.

Function tests included in the project:
- Account -> Get Details
- Account -> Mark as Favorite
- Account -> Add to Watchlist
- Account -> Get Favorite Movies
- Account -> Get Movie Watchlist
- Companies -> Get Details
- Genres -> Get Movie List, Get TV List
- Lists -> Create List
- Lists -> Add Movie
- Lists -> Remove Movies
- Movies -> Get Top Rated
- Movies -> Get Details
- Movies -> Positive/Negative Rate Movie
- Movies -> Delete Rating

Note: It may give an error after creating lists 4 or 5 times with the CreateList function. Even if the lists are deleted, an error may occur while generating the list with the same explanation. If the description of the requestBody variable in the ListService class is changed and retried, the function will work without error.

## LICENSE
MIT LICENSE
