package com.suren.myandroidtemplate.di;

import com.suren.myandroidtemplate.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityProvidersModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
