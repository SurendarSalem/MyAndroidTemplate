package com.suren.myandroidtemplate.ui.restaurants;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.suren.myandroidtemplate.AbsentLiveData;
import com.suren.myandroidtemplate.db.entity.Restaurant;
import com.suren.myandroidtemplate.repository.RestaurantRepository;
import com.suren.myandroidtemplate.vo.Objects;
import com.suren.myandroidtemplate.vo.Resource;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;


public class RestaurantListViewModel extends ViewModel {

    private final MutableLiveData<String> query = new MutableLiveData<>();
    private final LiveData<Resource<List<Restaurant>>> restaurants;

    @Inject
    public RestaurantListViewModel(@NonNull RestaurantRepository tmdbRepository) {
        restaurants = tmdbRepository.getRestaurants();

    }

    public LiveData<Resource<List<Restaurant>>> getRestaurants() {
        return restaurants;
    }

    public void setSearchQuery(@NonNull String originalInput) {
        String input = originalInput.toLowerCase(Locale.getDefault()).trim();
        if (Objects.equals(input, query.getValue())) {
            return;
        }
        query.setValue(input);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

}