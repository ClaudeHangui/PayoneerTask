
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class ReturnCodeApiResponse {

    @SerializedName("name")
    private String mName;
    @SerializedName("source")
    private String mSource;
    /*
    public static class Builder {

        private String mName;
        private String mSource;

        public ReturnCodeApiResponse.Builder withName(String name) {
            mName = name;
            return this;
        }

        public ReturnCodeApiResponse.Builder withSource(String source) {
            mSource = source;
            return this;
        }

        public ReturnCodeApiResponse build() {
            ReturnCodeApiResponse returnCodeApiResponse = new ReturnCodeApiResponse();
            returnCodeApiResponse.mName = mName;
            returnCodeApiResponse.mSource = mSource;
            return returnCodeApiResponse;
        }

    }

     */

}
