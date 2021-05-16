
package com.changui.payoneerhomeexercise.data.apiresponse;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter @Builder
public class PaymentMethodsApiResponse {
    public PaymentMethodsApiResponse(IdentificationApiResponse mIdentificationApiResponse, String mIntegrationType, InteractionApiResponse mInteractionApiResponse, LinksApiResponse mLinksApiResponse, NetworksApiResponse mNetworksApiResponse, String mOperation, String mOperationType, PaymentApiResponse mPaymentApiResponse, String mResultCode, String mResultInfo, ReturnCodeApiResponse mReturnCodeApiResponse, StatusApiResponse mStatusApiResponse, StyleApiResponse mStyleApiResponse, String mTimestamp) {
        this.mIdentificationApiResponse = mIdentificationApiResponse;
        this.mIntegrationType = mIntegrationType;
        this.mInteractionApiResponse = mInteractionApiResponse;
        this.mLinksApiResponse = mLinksApiResponse;
        this.mNetworksApiResponse = mNetworksApiResponse;
        this.mOperation = mOperation;
        this.mOperationType = mOperationType;
        this.mPaymentApiResponse = mPaymentApiResponse;
        this.mResultCode = mResultCode;
        this.mResultInfo = mResultInfo;
        this.mReturnCodeApiResponse = mReturnCodeApiResponse;
        this.mStatusApiResponse = mStatusApiResponse;
        this.mStyleApiResponse = mStyleApiResponse;
        this.mTimestamp = mTimestamp;
    }

    @SerializedName("identification")
    private IdentificationApiResponse mIdentificationApiResponse;
    @SerializedName("integrationType")
    private String mIntegrationType;
    @SerializedName("interaction")
    private InteractionApiResponse mInteractionApiResponse;
    @SerializedName("links")
    private LinksApiResponse mLinksApiResponse;
    @SerializedName("networks")
    private NetworksApiResponse mNetworksApiResponse;
    @SerializedName("operation")
    private String mOperation;
    @SerializedName("operationType")
    private String mOperationType;
    @SerializedName("payment")
    private PaymentApiResponse mPaymentApiResponse;
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("resultInfo")
    private String mResultInfo;
    @SerializedName("returnCode")
    private ReturnCodeApiResponse mReturnCodeApiResponse;
    @SerializedName("status")
    private StatusApiResponse mStatusApiResponse;
    @SerializedName("style")
    private StyleApiResponse mStyleApiResponse;
    @SerializedName("timestamp")
    private String mTimestamp;

    public LinksApiResponse getmLinksApiResponse() {
        return mLinksApiResponse;
    }

    public NetworksApiResponse getmNetworksApiResponse() {
        return mNetworksApiResponse;
    }
}
