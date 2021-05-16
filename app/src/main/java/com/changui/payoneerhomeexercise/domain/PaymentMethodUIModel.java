package com.changui.payoneerhomeexercise.domain;

public class PaymentMethodUIModel {
    private String paymentMethodCodeName;
    private String logoUrl;
    private String label;
    private boolean isValid;


    public PaymentMethodUIModel(String code, String logo, String label, boolean isValid) {
        paymentMethodCodeName = code;
        this.logoUrl = logo;
        this.label = label;
        this.isValid = isValid;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getLabel() {
        return label;
    }

    public String getPaymentMethodCodeName() {
        return paymentMethodCodeName;
    }

    public boolean isValid() {
        return isValid;
    }
}
