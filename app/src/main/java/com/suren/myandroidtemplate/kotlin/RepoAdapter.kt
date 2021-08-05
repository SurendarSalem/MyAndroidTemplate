package com.suren.myandroidtemplate.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suren.myandroidtemplate.R
import com.suren.myandroidtemplate.databinding.RepoItemBinding
import com.suren.myandroidtemplate.kotlin.RepoAdapter.RepoHolder
import com.suren.myandroidtemplate.ui.restaurants.adapter.RestaurantListAdapter.RestaurantViewHolder

class RepoAdapter(diffCallback: DiffUtil.ItemCallback<Repo>) : ListAdapter<Repo, RepoHolder>(diffCallback) {

    var inflater: LayoutInflater? = null;

    class RepoHolder(binding: RepoItemBinding, itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: RepoItemBinding? = null;

        init {
            this.binding = binding
        }

        fun bind(repo: Repo) {
            binding?.repo = repo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding: RepoItemBinding? = inflater?.let { DataBindingUtil.inflate(it, R.layout.repo_item, parent, false) }
        return binding?.let { RepoHolder(it, binding.root) }!!
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
