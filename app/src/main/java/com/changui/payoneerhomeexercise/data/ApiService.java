package com.changui.payoneerhomeexercise.data;

import com.changui.payoneerhomeexercise.data.apiresponse.PaymentMethodsApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("listresult.json")
    Single<PaymentMethodsApiResponse> getPaymentMethods();
}
