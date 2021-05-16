
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Builder
public class LinksApiResponse {

    @SerializedName("lang")
    private String mLang;
    @SerializedName("logo")
    private String mLogo;
    @SerializedName("operation")
    private String mOperation;
    @SerializedName("self")
    private String mSelf;
    @SerializedName("validation")
    private String mValidation;

    public String getmLang() {
        return mLang;
    }

    public String getmLogo() {
        return mLogo;
    }

    public String getmOperation() {
        return mOperation;
    }

    public String getmSelf() {
        return mSelf;
    }

    public String getmValidation() {
        return mValidation;
    }
}
