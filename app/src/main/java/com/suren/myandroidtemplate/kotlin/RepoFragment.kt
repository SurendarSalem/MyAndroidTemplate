package com.suren.myandroidtemplate.kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.suren.myandroidtemplate.R
import com.suren.myandroidtemplate.databinding.FragmentRepoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RepoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RepoFragment : Fragment() {

    private var rv: View? = null
    var viewBinding: FragmentRepoBinding? = null
    var viewModel: RepoViewModel? = null
    var adapter: RepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_repo, container, false)
        initViews()
        return viewBinding?.root;
    }

    private fun initViews() {
        viewBinding?.rvRepos?.layoutManager = LinearLayoutManager(context)
        adapter =  RepoAdapter(diffCallback = RepoDiff())
        viewBinding?.rvRepos?.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java);
        viewModel?.data?.observe(viewLifecycleOwner, { data ->
           adapter?.submitList(data)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = RepoFragment()
    }

    class RepoDiff : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean = oldItem.equals(newItem)
    }
}