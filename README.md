# SeriesInfo

Seriesinfo is a web application that shows information about series and movies.

To do this, it uses the Themoviedb API, from which it obtains the following information:

List of movies.
List of series.
Summary.
Score of the movie or serie.
Actors.
Movies and series in which the actors have worked.
Actor popularity.
Personal information about them. 
Personalized lists of users.

The application can be used without registering. However, only registered users will be able to create custom lists.

We can start a session on the platform, to be able to access our personal lists.

We can log out to be able to enter with another user.

We can enter as a guest to access the list of series and movies, but we will not have personal lists.

In order to register in the application, it is necessary to do it previously on the page www.themoviedb.org, thus obtaining the v3 auth key and the v4 auth read access token, that correspond in the seriesInfo web application with the API Key and the Request Token respectively.

Once registered in the application, we can access the following features:

Main screen to access movies or series
List of movies.
Movie search engine.
Movie info: summary, score, actors, add movie to a list (if you have created one before).
If you choose an actor, you can see his popularity, personal information, biography and the films he has worked on.

List of series.
Series search engine.
Serie info: summary, score, seasons, add serie to a list (if you have created one before).
If you choose a season, you will see the chapters that compose it (with a summary of them).

List of personal lists. We can create personal lists, to which we will add series and movies according to our needs.
We can edit lists, changing their name and description, adding or removing content from them, selecting an image that identifies it (from among the movies or series in it) or removing the list completely.

Use of javascript to add and remove movies and series from a list. We will have 2 lists:
On the left a search engine to search for movies or series.
On the right, the list of movies and series that make up the list.

When selecting a series or movie from the list on the left, it will be automatically added to the list on the right, being able to delete the ones we want and obtaining the results instantly.


