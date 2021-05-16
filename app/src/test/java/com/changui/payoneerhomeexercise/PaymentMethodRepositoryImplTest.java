package com.changui.payoneerhomeexercise;

import com.changui.payoneerhomeexercise.data.ApiService;
import com.changui.payoneerhomeexercise.data.GetPaymentMethodsMapper;
import com.changui.payoneerhomeexercise.data.PaymentMethodRepositoryImpl;
import com.changui.payoneerhomeexercise.data.apiresponse.PaymentMethodsApiResponse;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.changui.payoneerhomeexercise.domain.SchedulersFacade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PaymentMethodRepositoryImplTest {
    @Mock private ApiService mockApiService;
    @Mock private GetPaymentMethodsMapper mockPaymentMethodsMapper;
    @Mock private SchedulersFacade mockSchedulersFacade;
    private PaymentMethodRepositoryImpl paymentMethodRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentMethodRepository = new PaymentMethodRepositoryImpl(mockApiService, mockPaymentMethodsMapper, mockSchedulersFacade);
    }

    @Test
    @DisplayName("Verify api call returns a result")
    void verifyApiCallReturnsResponse() throws IOException {
        TestObserver<List<PaymentMethodUIModel>> resultTestObserver;
        PaymentMethodsApiResponse apiResponse = Utils.getApiResponse();
        List<PaymentMethodUIModel> actualPymentMethodUIModels = Utils.getMethods();

        TestScheduler ioTestScheduler = new TestScheduler();
        //doReturn(ioTestScheduler).when(mockSchedulersFacade).provideIO();
        TestScheduler mainTestScheduler = new TestScheduler();
        //doReturn(mainTestScheduler).when(mockSchedulersFacade).provideUIThread();

        doReturn(Single.just(apiResponse)).when(mockApiService).getPaymentMethods();
        when(mockPaymentMethodsMapper.mapToUI(apiResponse)).thenReturn(actualPymentMethodUIModels);

        when(mockSchedulersFacade.provideIO()).thenReturn(ioTestScheduler);
        when(mockSchedulersFacade.provideUIThread()).thenReturn(mainTestScheduler);

        resultTestObserver = paymentMethodRepository.getPaymentMethods()
                .subscribeOn(ioTestScheduler)
                .observeOn(mainTestScheduler)
                .test();

        verify(mockApiService, times(1)).getPaymentMethods();
        resultTestObserver.dispose();
    }
}