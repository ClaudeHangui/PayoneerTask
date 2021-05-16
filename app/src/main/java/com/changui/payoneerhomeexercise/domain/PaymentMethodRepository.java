package com.changui.payoneerhomeexercise.domain;

import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import java.util.List;
import io.reactivex.Single;

public interface PaymentMethodRepository {
    Single<List<PaymentMethodUIModel>> getPaymentMethods();
}
