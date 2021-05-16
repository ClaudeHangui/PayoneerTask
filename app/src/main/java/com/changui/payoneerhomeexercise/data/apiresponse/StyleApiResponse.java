
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class StyleApiResponse {

    @SerializedName("language")
    private String mLanguage;

    public String getLanguage() {
        return mLanguage;
    }
    /*
    public static class Builder {

        private String mLanguage;

        public StyleApiResponse.Builder withLanguage(String language) {
            mLanguage = language;
            return this;
        }

        public StyleApiResponse build() {
            StyleApiResponse styleApiResponse = new StyleApiResponse();
            styleApiResponse.mLanguage = mLanguage;
            return styleApiResponse;
        }

    }

     */

}
