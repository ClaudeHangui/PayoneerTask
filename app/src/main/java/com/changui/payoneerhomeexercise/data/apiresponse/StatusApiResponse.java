
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class StatusApiResponse {

    @SerializedName("code")
    private String mCode;
    @SerializedName("reason")
    private String mReason;
    /*
    public static class Builder {

        private String mCode;
        private String mReason;

        public StatusApiResponse.Builder withCode(String code) {
            mCode = code;
            return this;
        }

        public StatusApiResponse.Builder withReason(String reason) {
            mReason = reason;
            return this;
        }

        public StatusApiResponse build() {
            StatusApiResponse statusApiResponse = new StatusApiResponse();
            statusApiResponse.mCode = mCode;
            statusApiResponse.mReason = mReason;
            return statusApiResponse;
        }

    }

     */

}
