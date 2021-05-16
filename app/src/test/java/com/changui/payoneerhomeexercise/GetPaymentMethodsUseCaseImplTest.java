package com.changui.payoneerhomeexercise;


import com.changui.payoneerhomeexercise.domain.BaseFailureFactory;
import com.changui.payoneerhomeexercise.domain.Failure;
import com.changui.payoneerhomeexercise.domain.GetPaymentMethodsUseCaseImpl;
import com.changui.payoneerhomeexercise.domain.PaymentMethodRepository;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.changui.payoneerhomeexercise.domain.Result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetPaymentMethodsUseCaseImplTest {
    @Mock private PaymentMethodRepository mockPaymentMethodRepository;
    @Mock private BaseFailureFactory mockFailureFactory;
    private GetPaymentMethodsUseCaseImpl getPaymentMethodsUseCase;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getPaymentMethodsUseCase = new GetPaymentMethodsUseCaseImpl(mockPaymentMethodRepository, mockFailureFactory);
    }

    @Test
    @DisplayName("When fetching payment methods, a successful Result is provided")
    void verifyReturnedPaymentMethods() {
        doReturn(Single.just(Result.success(null))).when(mockPaymentMethodRepository).getPaymentMethods();
        getPaymentMethodsUseCase.getPayments();
        verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
        verifyNoMoreInteractions(mockPaymentMethodRepository);
    }

    @Nested
    @DisplayName("Failure scenario")
    class ExistingPaymentMethods {
        Failure failure;
        TestObserver<Result<List<PaymentMethodUIModel>>> resultTestObserver;

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to BadRequest error")
        void verifyBadRequestFailureReturn() {
            failure = Failure.BadRequestError;

            HttpException mockHttpException = new HttpException(Response.error(404, mock(ResponseBody.class)));

            doReturn(Single.just(Result.error(mockFailureFactory.produce(mockHttpException),null)))
                    .when(mockPaymentMethodRepository).getPaymentMethods();

            resultTestObserver = getPaymentMethodsUseCase.getPayments().test();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
            resultTestObserver.dispose();
        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to Server error")
        void verifyServerFailureReturn() {
            failure = Failure.ServerError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            Single<Result<List<PaymentMethodUIModel>>> res = getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);

        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to unknown error")
        void verifyUnknownFailureReturn() {
            failure = Failure.UnknownError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to network error")
        void verifyNetworkFailureReturn() {
            failure = Failure.NetworkError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to not found error")
        void verifyNotFoundFailureReturn() {
            failure = Failure.NotFoundError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to forbidden error")
        void verifyForbiddenFailureReturn() {
            failure = Failure.ForbiddenError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to gateway error")
        void verifyGatewayFailureReturn() {
            failure = Failure.GatewayError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
        }

        @Test
        @DisplayName("When fetching payment methods, then error Result is returned to unauthorised error")
        void verifyUnauthorisedFailureReturn() {
            failure = Failure.UnauthorisedError;
            doReturn(Single.just(Result.error(failure,null))).when(mockPaymentMethodRepository).getPaymentMethods();
            getPaymentMethodsUseCase.getPayments();
            verify(mockPaymentMethodRepository, times(1)).getPaymentMethods();
            verifyNoMoreInteractions(mockPaymentMethodRepository);
        }
    }



}