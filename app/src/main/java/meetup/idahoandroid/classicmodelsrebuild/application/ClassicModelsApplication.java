package meetup.idahoandroid.classicmodelsrebuild.application;

import android.app.Application;


public class ClassicModelsApplication extends Application {

    private static ClassicModelsApplication application;

    public static ClassicModelsApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUpApplicationComponent();
    }

    private void setUpApplicationComponent() {
        // TODO: 2/19/17
    }
}
