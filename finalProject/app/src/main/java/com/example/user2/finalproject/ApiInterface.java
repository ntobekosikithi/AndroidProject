package com.example.user2.finalproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("movie/popular")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("discover/tv")
    Call<ShowsSetAndGet> getTopRatedShows(@Query("api_key") String apiKey);

    @GET("discover/movie?api_key=c94431cab6597dab45a1c126e000512f&certification_country=US&certification=R&sort_by=vote_average.desc")
    Call<MoviesResponse> getTopRatedRated();

    @GET("discover/movie?api_key=c94431cab6597dab45a1c126e000512f&primary_release_year=2016&sort_by=vote_average")
    Call<MoviesResponse> getTopRatedBestOfYear();

    @GET("discover/movie?api_key=c94431cab6597dab45a1c126e000512f&primary_release_date.gte=2016-10-16&primary_release_date.lte=2016-12-30")
    Call<MoviesResponse> getTopRatedTheathre();

    @GET("discover/movie?api_key=c94431cab6597dab45a1c126e000512f&certification_country=US&certification.lte=G&sort_by=popularity.desc")
    Call<MoviesResponse> getKidsmovies();

    @GET("search/movie?api_key=968cca12b1a8492036b1e1e05af57e3f")
    Call<MoviesResponse> getSearchResults(@Query("query") String query);
}
