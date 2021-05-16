package com.changui.payoneerhomeexercise.data;

import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.changui.payoneerhomeexercise.domain.PaymentMethodRepository;
import com.changui.payoneerhomeexercise.domain.SchedulersFacade;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;

public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {
    private final ApiService apiService;
    private final GetPaymentMethodsMapper paymentMethodsMapper;
    private final SchedulersFacade schedulersFacade;
    @Inject
    public PaymentMethodRepositoryImpl(ApiService apiService, GetPaymentMethodsMapper mapper, SchedulersFacade facade) {
        this.apiService = apiService;
        this.paymentMethodsMapper = mapper;
        this.schedulersFacade = facade;
    }

    @Override
    public Single<List<PaymentMethodUIModel>> getPaymentMethods() {
        return apiService.getPaymentMethods()
                .map(paymentMethodsMapper::mapToUI)
                .subscribeOn(schedulersFacade.provideIO())
                .observeOn(schedulersFacade.provideUIThread());
    }
}
