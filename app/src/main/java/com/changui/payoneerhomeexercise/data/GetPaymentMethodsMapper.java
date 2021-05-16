package com.changui.payoneerhomeexercise.data;

import com.changui.payoneerhomeexercise.data.apiresponse.ApplicableApiResponse;
import com.changui.payoneerhomeexercise.data.apiresponse.NetworksApiResponse;
import com.changui.payoneerhomeexercise.data.apiresponse.PaymentMethodsApiResponse;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.changui.payoneerhomeexercise.domain.PaymentMethodValidity;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetPaymentMethodsMapper implements Mapper<PaymentMethodsApiResponse, List<PaymentMethodUIModel>> {
    @Override
    public List<PaymentMethodUIModel> mapToUI(PaymentMethodsApiResponse input) {
        List<PaymentMethodUIModel> paymentMethodUIModelList = new ArrayList<>();
        NetworksApiResponse networksApiResponse = input.getmNetworksApiResponse();
        if (networksApiResponse != null) {
            List<ApplicableApiResponse> applicableApiResponseList = networksApiResponse.getmApplicableApiResponse();
            if (applicableApiResponseList != null && applicableApiResponseList.size() > 0) {
                for (ApplicableApiResponse item : applicableApiResponseList) {
                    PaymentMethodUIModel paymentMethodUIModel = new PaymentMethodUIModel(
                            item.getmCode(),
                            item.getmLinksApiResponse().getmLogo(),
                            item.getmLabel(),
                            PaymentMethodValidity.isValid(item.getmMethod()));
                    paymentMethodUIModelList.add(paymentMethodUIModel);
                }
            }
        }
        return paymentMethodUIModelList;
    }
}
