package com.suren.myandroidtemplate.ui.restaurants;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.NotificationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suren.myandroidtemplate.R;
import com.suren.myandroidtemplate.databinding.RestaurantListFragmentBinding;
import com.suren.myandroidtemplate.db.entity.Restaurant;
import com.suren.myandroidtemplate.di.ViewModelFactory;
import com.suren.myandroidtemplate.ui.restaurants.adapter.RestaurantListAdapter;
import com.suren.myandroidtemplate.vo.Resource;
import com.suren.myandroidtemplate.vo.Status;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.android.support.DaggerFragment;
import retrofit2.Retrofit;

public class RestaurantListFragment extends DaggerFragment {

    @Inject
    Retrofit retrofit;

    @Inject
    ViewModelFactory viewModelFactory;
    RestaurantListViewModel restaurantListViewModel;
    RestaurantListAdapter restaurantListAdapter;
    RestaurantListFragmentBinding restaurantListFragmentBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantListAdapter = new RestaurantListAdapter(new RestaurantDiffCallback());
    }

    public static RestaurantListFragment newInstance() {
        return new RestaurantListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        restaurantListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.restaurant_list_fragment, container, false);
        initViews();
        return restaurantListFragmentBinding.getRoot();
    }

    private void initViews() {
        restaurantListFragmentBinding.rvRestaurants.setLayoutManager(new LinearLayoutManager(getContext()));
        restaurantListFragmentBinding.rvRestaurants.setAdapter(restaurantListAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        restaurantListViewModel = new ViewModelProvider(this, viewModelFactory).get(RestaurantListViewModel.class);
        /*restaurantListViewModel.getRestaurants().observe(getViewLifecycleOwner(), listResource -> {
            if (listResource.status == Status.LOADING) {
                restaurantListFragmentBinding.progressBar.setVisibility(View.VISIBLE);
            } else {
                restaurantListFragmentBinding.progressBar.setVisibility(View.GONE);
            }
            restaurantListAdapter.submitList(listResource.data);
        });*/
        restaurantListViewModel.getPaging().observe(getViewLifecycleOwner(), listResource -> {
            restaurantListAdapter.submitList(listResource);
        });
    }

    static class RestaurantDiffCallback extends DiffUtil.ItemCallback<Restaurant> {

        @Override
        public boolean areItemsTheSame(@NonNull Restaurant oldItem, @NonNull Restaurant newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Restaurant oldItem, @NonNull Restaurant newItem) {
            return newItem.equals(oldItem);
        }
    }
}