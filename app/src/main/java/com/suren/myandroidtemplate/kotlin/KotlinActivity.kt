package com.suren.myandroidtemplate.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suren.myandroidtemplate.R

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        showFragment();
    }

    private fun showFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, RepoFragment.newInstance(), RepoFragment::class.java.name).commit()
    }
}