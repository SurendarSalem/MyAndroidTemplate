package com.suren.myandroidtemplate.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.suren.myandroidtemplate.api.RestaurantService;
import com.suren.myandroidtemplate.db.RestaurantDB;
import com.suren.myandroidtemplate.db.dao.RestaurantDao;
import com.suren.myandroidtemplate.db.entity.Restaurant;
import com.suren.myandroidtemplate.rest.ApiResponse;
import com.suren.myandroidtemplate.rest.AppExecutors;
import com.suren.myandroidtemplate.rest.NetworkBoundResource;
import com.suren.myandroidtemplate.vo.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RestaurantRepository {
    private RestaurantService restaurantService;
    private RestaurantDB restaurantDB;
    private RestaurantDao restaurantDao;
    private final AppExecutors appExecutors;

    @Inject
    public RestaurantRepository(AppExecutors appExecutors, RestaurantService restaurantService, RestaurantDB restaurantDB, RestaurantDao restaurantDao) {
        this.restaurantService = restaurantService;
        this.appExecutors = appExecutors;
        this.restaurantDB = restaurantDB;
        this.restaurantDao = restaurantDao;
    }

    public LiveData<Resource<List<Restaurant>>> getRestaurants() {
        return new NetworkBoundResource<List<Restaurant>, List<Restaurant>>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull List<Restaurant> item) {
                restaurantDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Restaurant> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<Restaurant>> loadFromDb() {
                return restaurantDao.findAll();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Restaurant>>> createCall() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return restaurantService.getRestaurants();
            }
        }.asLiveData();
    }

}
