package com.changui.payoneerhomeexercise.domain;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;

public class GetPaymentMethodsUseCaseImpl implements GetPaymentMethodsUseCase {
    private final PaymentMethodRepository paymentMethodRepository;
    private final BaseFailureFactory failureFactory;
    //private final SchedulersFacade schedulersFacade;

    @Inject
    public GetPaymentMethodsUseCaseImpl(PaymentMethodRepository repository,
                                        BaseFailureFactory factory) {
        this.paymentMethodRepository = repository;
        this.failureFactory = factory;
        //this.schedulersFacade = schedulers;
    }

    @Override
    public Single<Result<List<PaymentMethodUIModel>>> getPayments() {
        return paymentMethodRepository.getPaymentMethods()
                .map(Result::success)
                .onErrorReturn(error -> Result.error(failureFactory.produce(error), null));
                //.observeOn(schedulersFacade.provideUIThread());
    }
}
