package com.changui.payoneerhomeexercise;

import com.changui.payoneerhomeexercise.data.GetPaymentMethodsMapper;
import com.changui.payoneerhomeexercise.data.ApiService;
import com.changui.payoneerhomeexercise.data.BaseFailureFactoryImpl;
import com.changui.payoneerhomeexercise.data.PaymentMethodRepositoryImpl;
import com.changui.payoneerhomeexercise.domain.BaseFailureFactory;
import com.changui.payoneerhomeexercise.domain.PaymentMethodRepository;
import com.changui.payoneerhomeexercise.domain.SchedulerFacadeImpl;
import com.changui.payoneerhomeexercise.domain.SchedulersFacade;
import com.changui.payoneerhomeexercise.domain.GetPaymentMethodsUseCase;
import com.changui.payoneerhomeexercise.domain.GetPaymentMethodsUseCaseImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public abstract class Injector {
    private static final String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/";

    @Singleton
    @Provides
    public static HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    @Provides
    public static Interceptor provideApiInterceptor() {
        return chain -> {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        };
    }

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient(Interceptor apiInterceptor, HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(apiInterceptor)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static ApiService provideApi(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    static GetPaymentMethodsMapper provideMapper(){
        return new GetPaymentMethodsMapper();
    }

    @Singleton
    @Provides
    static BaseFailureFactory bindBaseFailureFactory(){
        return new BaseFailureFactoryImpl();
    }

    @Provides
    @Singleton
    static SchedulersFacade bindSchedulersFacade(){
        return new SchedulerFacadeImpl()
;    }

    @Singleton
    @Binds
    public abstract PaymentMethodRepository bindPaymentMethodRepository(PaymentMethodRepositoryImpl paymentMethodRepositoryImpl);

    @Singleton
    @Binds
    public abstract GetPaymentMethodsUseCase bindUseCase(GetPaymentMethodsUseCaseImpl getPaymentMethodsUseCaseImpl);


}
