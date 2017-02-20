package meetup.idahoandroid.classicmodelsrebuild.application.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meetup.idahoandroid.classicmodelsrebuild.landing.ModelsApi;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public ModelsApi provideConfigurationApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl("") // TODO: 2/19/17
                .build()
                .create(ModelsApi.class);
    }
}
