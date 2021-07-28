package com.suren.myandroidtemplate.di;

import android.app.Application;

import com.suren.myandroidtemplate.AppApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        FragmentModule.class,
        ViewModelModule.class,
        NetworkModule.class,
        RoomModule.class,
        ActivityProvidersModule.class
})
@Singleton
public interface AppComponent extends AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
