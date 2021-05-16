package com.changui.payoneerhomeexercise.domain;

import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.changui.payoneerhomeexercise.domain.Result;
import java.util.List;
import io.reactivex.Single;

public interface GetPaymentMethodsUseCase {
    Single<Result<List<PaymentMethodUIModel>>> getPayments();
}
