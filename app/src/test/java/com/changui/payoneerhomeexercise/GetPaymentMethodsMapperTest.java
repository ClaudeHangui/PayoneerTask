package com.changui.payoneerhomeexercise;

import com.changui.payoneerhomeexercise.data.GetPaymentMethodsMapper;
import com.changui.payoneerhomeexercise.data.apiresponse.PaymentMethodsApiResponse;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.List;

import static com.changui.payoneerhomeexercise.Utils.getApiResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetPaymentMethodsMapperTest {
    private GetPaymentMethodsMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new GetPaymentMethodsMapper();
    }

    @Test
    @DisplayName("Given an api response with a non-null PaymentMethodsApiResponse object return a PaymentMethodUIModel list")
    void verifyMapApiResponseToUI() throws IOException {
        PaymentMethodsApiResponse apiResponse = getApiResponse();
        List<PaymentMethodUIModel> actualPaymentMethodUIModels = mapper.mapToUI(apiResponse);
        assertEquals(actualPaymentMethodUIModels.size(), 17);
    }


}