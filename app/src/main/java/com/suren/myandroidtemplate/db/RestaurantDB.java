package com.suren.myandroidtemplate.db;

import android.graphics.Movie;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.suren.myandroidtemplate.db.dao.RestaurantDao;
import com.suren.myandroidtemplate.db.entity.Restaurant;

/**
 * Main database description.
 */
@Database(entities = {com.suren.myandroidtemplate.db.entity.Restaurant.class}, version = 1,exportSchema = false)
public abstract class RestaurantDB extends RoomDatabase {

    abstract public RestaurantDao restaurantDao();

}
