
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class IdentificationApiResponse {

    @SerializedName("longId")
    private String mLongId;
    @SerializedName("shortId")
    private String mShortId;
    @SerializedName("transactionId")
    private String mTransactionId;
    /*
    public static class Builder {

        private String mLongId;
        private String mShortId;
        private String mTransactionId;

        public IdentificationApiResponse.Builder withLongId(String longId) {
            mLongId = longId;
            return this;
        }

        public IdentificationApiResponse.Builder withShortId(String shortId) {
            mShortId = shortId;
            return this;
        }

        public IdentificationApiResponse.Builder withTransactionId(String transactionId) {
            mTransactionId = transactionId;
            return this;
        }

        public IdentificationApiResponse build() {
            IdentificationApiResponse identificationApiResponse = new IdentificationApiResponse();
            identificationApiResponse.mLongId = mLongId;
            identificationApiResponse.mShortId = mShortId;
            identificationApiResponse.mTransactionId = mTransactionId;
            return identificationApiResponse;
        }

    }

     */

}
