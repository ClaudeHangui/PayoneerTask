
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class PaymentApiResponse {

    @SerializedName("amount")
    private Long mAmount;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("reference")
    private String mReference;
    /*
    public static class Builder {

        private Long mAmount;
        private String mCurrency;
        private String mReference;

        public PaymentApiResponse.Builder withAmount(Long amount) {
            mAmount = amount;
            return this;
        }

        public PaymentApiResponse.Builder withCurrency(String currency) {
            mCurrency = currency;
            return this;
        }

        public PaymentApiResponse.Builder withReference(String reference) {
            mReference = reference;
            return this;
        }

        public PaymentApiResponse build() {
            PaymentApiResponse paymentApiResponse = new PaymentApiResponse();
            paymentApiResponse.mAmount = mAmount;
            paymentApiResponse.mCurrency = mCurrency;
            paymentApiResponse.mReference = mReference;
            return paymentApiResponse;
        }

    }

     */

}
