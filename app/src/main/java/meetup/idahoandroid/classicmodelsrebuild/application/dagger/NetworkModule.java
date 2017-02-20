package meetup.idahoandroid.classicmodelsrebuild.application.dagger;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor.Level provideHttpLoggingInterceptorLevel() {
        return HttpLoggingInterceptor.Level.BODY;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder,
                                            HttpLoggingInterceptor.Level level) {
        //Log HTTP request and response data in debug mode
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(level);
        builder.addInterceptor(loggingInterceptor);

        return builder.build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

}
