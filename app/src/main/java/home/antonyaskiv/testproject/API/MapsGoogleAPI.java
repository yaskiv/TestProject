package home.antonyaskiv.testproject.API;

import android.app.Application;

import home.antonyaskiv.testproject.Model.API;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AntonYaskiv on 21.11.2017.
 */

public interface MapsGoogleAPI {
    @GET("maps/api/place/nearbysearch/json?")
    Observable<API> get(@Query("location")String location, @Query("radius")String radius, @Query("key")String API_KEY);
}
