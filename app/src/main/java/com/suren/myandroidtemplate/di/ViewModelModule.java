package com.suren.myandroidtemplate.di;

import androidx.lifecycle.ViewModel;

import com.suren.myandroidtemplate.repository.RestaurantRepository;
import com.suren.myandroidtemplate.ui.restaurants.RestaurantListViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ViewModelModule {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    @Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }

    @Provides
    @IntoMap
    @ViewModelKey(RestaurantListViewModel.class)
    ViewModel restaurantListViewModel(RestaurantRepository restaurantRepository) {
        return new RestaurantListViewModel(restaurantRepository);
    }
}
