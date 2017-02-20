package meetup.idahoandroid.classicmodelsrebuild.application.dagger;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meetup.idahoandroid.classicmodelsrebuild.application.ClassicModelsApplication;

@Module
public class ApplicationModule {

    private ClassicModelsApplication application;

    public ApplicationModule(ClassicModelsApplication application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    ClassicModelsApplication providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Resources provideResources() {
        return application.getResources();
    }

    @Provides
    @Singleton
    GsonBuilder provideGsonBuilder() {
        GsonBuilder builder = new GsonBuilder();
        return builder;
    }

    @Provides
    @Singleton
    public Gson provideGson(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }
}
