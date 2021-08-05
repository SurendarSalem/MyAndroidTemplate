package com.suren.myandroidtemplate.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RepoViewModel : ViewModel() {
    lateinit var data: MutableLiveData<List<Repo>>

    init {
        data = MutableLiveData()
        addDummyData()
    }

    fun addDummyData() {
        val repos = listOf(Repo("Suren", "1"), Repo("Sudha", "2"), Repo("Malar", "3"), Repo("Krish", "4"))
        data.value= repos
    }
}