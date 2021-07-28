package com.suren.myandroidtemplate.di;

import android.app.Application;

import androidx.room.Room;

import com.suren.myandroidtemplate.db.RestaurantDB;
import com.suren.myandroidtemplate.db.dao.RestaurantDao;
import com.suren.myandroidtemplate.db.entity.Restaurant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RoomModule {

    @Singleton
    @Provides
    RestaurantDB providesRoomDatabase(Application app) {
        return Room.databaseBuilder(app, RestaurantDB.class, "RestaurantDB").build();
    }

    @Singleton
    @Provides
    RestaurantDao restaurantDao(RestaurantDB db){
        return db.restaurantDao();
    }

}
