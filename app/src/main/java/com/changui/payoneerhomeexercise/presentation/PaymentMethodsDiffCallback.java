package com.changui.payoneerhomeexercise.presentation;

import androidx.recyclerview.widget.DiffUtil;

import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;

import java.util.List;

public class PaymentMethodsDiffCallback extends DiffUtil.Callback {

    private List<PaymentMethodUIModel> oldList, newList;

    public PaymentMethodsDiffCallback(List<PaymentMethodUIModel> oldList, List<PaymentMethodUIModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getPaymentMethodCodeName().equals(newList.get(newItemPosition).getPaymentMethodCodeName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getPaymentMethodCodeName().equals(newList.get(newItemPosition).getPaymentMethodCodeName());
    }
}
