package com.changui.payoneerhomeexercise.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.changui.payoneerhomeexercise.databinding.ItemPaymentMethodBinding;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;

import java.util.List;

public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodViewHolder>{
    private List<PaymentMethodUIModel> paymentMethodsList;

    public PaymentMethodsAdapter(List<PaymentMethodUIModel> paymentMethodsList) {
        this.paymentMethodsList = paymentMethodsList;
    }

    @NonNull
    @Override
    public PaymentMethodsAdapter.PaymentMethodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentMethodViewHolder(ItemPaymentMethodBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodsAdapter.PaymentMethodViewHolder holder, int position) {
        PaymentMethodUIModel paymentMethod = paymentMethodsList.get(position);
        holder.itemPaymentMethodBinding.paymentMethodLogo.setImageURI(paymentMethod.getLogoUrl());
        holder.itemPaymentMethodBinding.paymentMethodName.setText(paymentMethod.getLabel());
    }

    @Override
    public int getItemCount() {
        return paymentMethodsList == null ? 0: paymentMethodsList.size();
    }

    public void setPaymentMethodsList(List<PaymentMethodUIModel> items) {
        PaymentMethodsDiffCallback diffCallback = new PaymentMethodsDiffCallback(paymentMethodsList, items);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        paymentMethodsList.clear();
        paymentMethodsList.addAll(items);
        diffResult.dispatchUpdatesTo(this);
    }

    public static class PaymentMethodViewHolder extends RecyclerView.ViewHolder {
        private final ItemPaymentMethodBinding itemPaymentMethodBinding;

        public PaymentMethodViewHolder(ItemPaymentMethodBinding itemView) {
            super(itemView.getRoot());
            this.itemPaymentMethodBinding = itemView;
        }
    }
}
