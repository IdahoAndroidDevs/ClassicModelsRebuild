package meetup.idahoandroid.classicmodelsrebuild.application.dagger;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import meetup.idahoandroid.classicmodelsrebuild.application.ClassicModelsApplication;
import retrofit2.Retrofit;

@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        ApiModule.class
})
@Singleton
public interface ApplicationComponent {

    Retrofit.Builder getRetrofitBuilder();

    Context getContext();

    ClassicModelsApplication getApplication();

    Resources getResources();

    Gson getGson();
}
