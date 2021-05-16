
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class InputElementApiResponse {

    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;

   /*
    public static class Builder {

        private String mName;
        private String mType;

        public InputElementApiResponse.Builder withName(String name) {
            mName = name;
            return this;
        }

        public InputElementApiResponse.Builder withType(String type) {
            mType = type;
            return this;
        }

        public InputElementApiResponse build() {
            InputElementApiResponse inputElementApiResponse = new InputElementApiResponse();
            inputElementApiResponse.mName = mName;
            inputElementApiResponse.mType = mType;
            return inputElementApiResponse;
        }

    }

    */

}
