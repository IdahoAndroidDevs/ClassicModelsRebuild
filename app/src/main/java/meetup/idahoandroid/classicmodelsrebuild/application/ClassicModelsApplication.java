package meetup.idahoandroid.classicmodelsrebuild.application;

import android.app.Application;

import meetup.idahoandroid.classicmodelsrebuild.application.dagger.ApiModule;
import meetup.idahoandroid.classicmodelsrebuild.application.dagger.ApplicationComponent;
import meetup.idahoandroid.classicmodelsrebuild.application.dagger.ApplicationModule;
import meetup.idahoandroid.classicmodelsrebuild.application.dagger.DaggerApplicationComponent;
import meetup.idahoandroid.classicmodelsrebuild.application.dagger.NetworkModule;


public class ClassicModelsApplication extends Application {

    private static ClassicModelsApplication application;

    private ApplicationComponent applicationComponent;

    public static ClassicModelsApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUpApplicationComponent();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void setUpApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .apiModule(new ApiModule())
                .build();
    }
}
