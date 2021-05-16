
package com.changui.payoneerhomeexercise.data.apiresponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Setter;

@SuppressWarnings("unused")
@Setter @Builder
public class NetworksApiResponse {

    @SerializedName("applicable")
    private List<ApplicableApiResponse> mApplicableApiResponse;

    public List<ApplicableApiResponse> getmApplicableApiResponse() {
        return mApplicableApiResponse;
    }
}
