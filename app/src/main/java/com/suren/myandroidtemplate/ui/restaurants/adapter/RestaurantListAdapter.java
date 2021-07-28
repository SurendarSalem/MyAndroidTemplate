package com.suren.myandroidtemplate.ui.restaurants.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.suren.myandroidtemplate.R;
import com.suren.myandroidtemplate.databinding.RestaurantItemBinding;
import com.suren.myandroidtemplate.db.entity.Restaurant;

public class RestaurantListAdapter extends ListAdapter<Restaurant, RestaurantListAdapter.RestaurantViewHolder> {
    private LayoutInflater layoutInflater;

    public RestaurantListAdapter(@NonNull DiffUtil.ItemCallback<Restaurant> diffCallback) {
        super(diffCallback);
    }

    protected RestaurantListAdapter(@NonNull AsyncDifferConfig<Restaurant> config) {
        super(config);
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        RestaurantItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.restaurant_item, parent, false);
        return new RestaurantViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        RestaurantItemBinding restaurantItemBinding;

        public RestaurantViewHolder(RestaurantItemBinding restaurantItemBinding) {
            super(restaurantItemBinding.getRoot());
            this.restaurantItemBinding = restaurantItemBinding;
        }

        public void bind(Restaurant item) {
            restaurantItemBinding.setRestaurant(item);
        }
    }
}
