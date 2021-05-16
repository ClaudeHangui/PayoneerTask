
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;

@SuppressWarnings("unused")
@Builder
public class ApplicableApiResponse {
    @SerializedName("code")
    private String mCode;
    @SerializedName("grouping")
    private String mGrouping;
    @SerializedName("inputElements")
    private List<InputElementApiResponse> mInputElementApiResponses;
    @SerializedName("label")
    private String mLabel;
    @SerializedName("links")
    private LinksApiResponse mLinksApiResponse;
    @SerializedName("method")
    private String mMethod;
    @SerializedName("operationType")
    private String mOperationType;
    @SerializedName("recurrence")
    private String mRecurrence;
    @SerializedName("redirect")
    private Boolean mRedirect;
    @SerializedName("registration")
    private String mRegistration;
    @SerializedName("selected")
    private Boolean mSelected;

    public String getmLabel() {
        return mLabel;
    }

    public LinksApiResponse getmLinksApiResponse() {
        return mLinksApiResponse;
    }

    public String getmMethod() {
        return mMethod;
    }

    public String getmCode() {
        return mCode;
    }
}
