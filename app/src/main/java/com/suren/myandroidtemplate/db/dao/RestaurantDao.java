package com.suren.myandroidtemplate.db.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.suren.myandroidtemplate.db.entity.Restaurant;

import java.util.List;

@Dao
public abstract class RestaurantDao {

    @Query("SELECT * FROM Restaurant")
    public abstract LiveData<List<Restaurant>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(List<Restaurant> Restaurants);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRestaurants(List<Restaurant> RestaurantList);

    @Query("DELETE FROM Restaurant")
    public abstract void deleteAll();

    @Query("SELECT * FROM Restaurant where id = :id")
    public abstract LiveData<Restaurant> searchRestaurantsById(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long createRestaurantIfNotExists(Restaurant Restaurant);
}
