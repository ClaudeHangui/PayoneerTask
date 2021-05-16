
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("unused")
@Getter @Setter @Builder
public class InteractionApiResponse {

    @SerializedName("code")
    private String mCode;
    @SerializedName("reason")
    private String mReason;

    /*
    public static class Builder {

        private String mCode;
        private String mReason;

        public InteractionApiResponse.Builder withCode(String code) {
            mCode = code;
            return this;
        }

        public InteractionApiResponse.Builder withReason(String reason) {
            mReason = reason;
            return this;
        }

        public InteractionApiResponse build() {
            InteractionApiResponse interactionApiResponse = new InteractionApiResponse();
            interactionApiResponse.mCode = mCode;
            interactionApiResponse.mReason = mReason;
            return interactionApiResponse;
        }

    }

     */

}
