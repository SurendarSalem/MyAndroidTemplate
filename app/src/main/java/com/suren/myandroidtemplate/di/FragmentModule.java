package com.suren.myandroidtemplate.di;

import com.suren.myandroidtemplate.ui.restaurants.RestaurantListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract RestaurantListFragment restaurantListFragment();
}
