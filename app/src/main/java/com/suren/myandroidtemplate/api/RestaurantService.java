package com.suren.myandroidtemplate.api;

import androidx.lifecycle.LiveData;

import com.suren.myandroidtemplate.db.entity.Restaurant;
import com.suren.myandroidtemplate.rest.ApiResponse;

import java.util.List;

import retrofit2.http.GET;

public interface RestaurantService {

    @GET("cannabis/random_cannabis?size=10")
    LiveData<ApiResponse<List<Restaurant>>> getRestaurants();

}
