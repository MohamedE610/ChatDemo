/*
package com.example.abdallah.chatdemo.Utils.RetrofitLib;

import com.example.abdallah.chatdemo.Models.Clients.Clients;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

*/
/**
 * Created by abdallah on 12/18/2017.
 *//*

public interface ApiInterface {
   */
/* @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);*//*

@Headers({
    "Accept: application/json",
    "Content-Type: application/json"
})
    @GET("clients")
    Call<Clients> getCompanyClients();

/*
      @GET("clients")
      Call<Clients> getCompanyClients(@Header("Accept") String acceptVal ,@Header("Content-Type") String contentTypeVal);
}
*/
